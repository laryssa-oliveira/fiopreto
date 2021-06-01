package com.example.fiopreto.data.remote.tips

import com.example.fiopreto.ImageTips
import com.example.fiopreto.data.repository.UploadTipsRepository
import com.example.fiopreto.data.remote.ResultWrapper
import com.example.fiopreto.data.remote.mappers.toModel
import com.example.fiopreto.extensions.wrapResponse
import okhttp3.MultipartBody

class UploadTipsRepositoryImpl (
    private val service: UploadTipsService
): UploadTipsRepository {

    override suspend fun uploadImageTips(image: MultipartBody.Part): ResultWrapper<ImageTips> =
        when(val result = wrapResponse { service.uploadImageTips(image) }) {
            is ResultWrapper.Failure -> ResultWrapper.Failure(result.error)
            is ResultWrapper.Success -> ResultWrapper.Success(result.data.toModel())
        }


}

