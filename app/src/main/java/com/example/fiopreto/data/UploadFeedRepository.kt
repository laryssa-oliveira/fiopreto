package com.example.fiopreto.data

import com.example.fiopreto.ImageFeed
import com.example.fiopreto.PostFeed
import com.example.fiopreto.data.remote.ResultWrapper
import okhttp3.MultipartBody

interface UploadFeedRepository {
    suspend fun uploadImageFeed(image: MultipartBody.Part) : ResultWrapper<ImageFeed>
}