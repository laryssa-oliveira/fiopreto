package com.example.fiopreto.data.remote.postsFeed

import com.example.fiopreto.ImageFeed
import com.example.fiopreto.data.Constants.HEADER_ACCESS_TOKEN
import com.example.fiopreto.data.UploadFeedRepository
import com.example.fiopreto.data.local.LocalDataSource
import com.example.fiopreto.data.remote.ResultWrapper
import com.example.fiopreto.data.remote.toModel
import com.example.fiopreto.extensions.wrapResponse
import okhttp3.MultipartBody
import retrofit2.http.Multipart

class UploadFeedRepositoryImpl (
    private val service: UploadFeedService
): UploadFeedRepository {

    override suspend fun uploadImageFeed(image: MultipartBody.Part): ResultWrapper<ImageFeed> =
        when(val result = wrapResponse { service.uploadImageFeed(image) }) {
            is ResultWrapper.Failure -> ResultWrapper.Failure(result.error)
            is ResultWrapper.Success -> ResultWrapper.Success(result.data.toModel())
        }


}