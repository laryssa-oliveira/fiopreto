package com.example.fiopreto.data.remote.tips

import com.google.gson.GsonBuilder
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface UploadTipsService {

    @Multipart
    @POST("post/tips/")

    suspend fun uploadImageTips(
        @Part image: MultipartBody.Part
    ): UploadTipsResponse

    companion object {
        fun newInstance(client: OkHttpClient): UploadTipsService = Retrofit.Builder()
            .baseUrl("https://fiopreto.herokuapp.com/api/v1/")
            .client(client)
            .addConverterFactory(
                GsonConverterFactory.create(
                GsonBuilder()
                    .setLenient()
                    .create()
            ))
            .build().create(UploadTipsService::class.java)


    }

}

