package com.example.fiopreto.data.repository


import com.example.fiopreto.ImageTips
import com.example.fiopreto.data.remote.ResultWrapper
import okhttp3.MultipartBody

interface UploadTipsRepository {
    suspend fun uploadImageTips(image: MultipartBody.Part) : ResultWrapper<ImageTips>
}
