package com.example.fiopreto.data.remote.postsFeed

import com.example.fiopreto.PostFeed
import com.example.fiopreto.extensions.wrapResponse
import com.example.fiopreto.data.Constants.HEADER_ACCESS_TOKEN
import com.example.fiopreto.data.FeedRepository
import com.example.fiopreto.data.local.LocalDataSource
import com.example.fiopreto.data.remote.ResultWrapper
import com.example.fiopreto.data.remote.toModel


class FeedRepositoryImpl(
    private val service: FeedService,
    private val localDataSource: LocalDataSource
) : FeedRepository {

    override suspend fun getPostsFeed(): ResultWrapper<List<PostFeed>> =
        when(val result = callPostsFeedEndpoint()) {
            is ResultWrapper.Failure -> ResultWrapper.Failure(result.error!!)
            is ResultWrapper.Success -> ResultWrapper.Success(
                result.data?.feedResp?.map {
                    it.toModel()
                }?: listOf()
            )
        }

    private suspend fun callPostsFeedEndpoint() = wrapResponse {
        service.getPostsFeed(
            accessToken = localDataSource.getHeadersFromPreferences()[HEADER_ACCESS_TOKEN] ?: ""
            /*client = localDataSource.getHeadersFromPreferences()[HEADER_CLIENT] ?: "",
            uid = localDataSource.getHeadersFromPreferences()[HEADER_UID] ?: ""*/
        )
    }

}