package com.example.fiopreto.data.remote.tips


import com.example.fiopreto.PostTips
import com.example.fiopreto.data.TipsRepository
import com.example.fiopreto.data.local.LocalDataSource
import com.example.fiopreto.data.remote.ResultWrapper
import com.example.fiopreto.data.Constants.HEADER_AUTHORIZATION
import com.example.fiopreto.data.remote.mappers.toModel
import com.example.fiopreto.extensions.wrapResponse

class TipsRepositoryImpl(
    private val service: TipsService,
    private val localDataSource: LocalDataSource
) : TipsRepository {

    override suspend fun getPostsTips(): ResultWrapper<List<PostTips>> =
        when (val result = callPostsTipsEndpoint()) {
            is ResultWrapper.Failure -> ResultWrapper.Failure(result.error!!)
            is ResultWrapper.Success -> ResultWrapper.Success(
                result.data?.tipsResp?.map {
                    it.toModel()
                } ?: listOf()
            )
        }

    private suspend fun callPostsTipsEndpoint() = wrapResponse {
        service.getPostsTips(
            auth = localDataSource.getHeadersFromPreferences()[HEADER_AUTHORIZATION] ?: ""
            /*authorization = "Bearer eyJhbGciOiJIUzM4NCIsInR5cCI6IkpXVCJ9.eyJzdWIiOnsiaWQiOjgsIm5hbWUiOiJBbmEgSnVsaWEiLCJlbWFpbCI6ImFuYWp1bGlhQGhvdG1haWwuY29tIn0sImlhdCI6MTYyMTkwOTQ5NSwiZXhwIjoxNjIyNTE0Mjk1fQ.rq8TJUXDiggyGNtN8HrZo6XMzuIdcZrWRynfoysxwz2YcOSYGexL-dx8nN65t4IZ"
            client = localDataSource.getHeadersFromPreferences()[HEADER_CLIENT] ?: "",
            uid = localDataSource.getHeadersFromPreferences()[HEADER_UID] ?: ""*/
        )
    }

}

