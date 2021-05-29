package com.example.fiopreto.data.remote.postsFeed

import com.example.fiopreto.data.remote.ResultWrapper
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import java.util.concurrent.TimeUnit

interface UploadFeedService {

    @Multipart
    @POST("image/")

    suspend fun uploadImageFeed(
    @Part image: MultipartBody.Part
    ): ResultWrapper<UploadFeedResponse>

    companion object{
        fun newInstance(client: OkHttpClient): UploadFeedService = Retrofit.Builder()
            .baseUrl("https://fiopreto.herokuapp.com/api/v1/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(UploadFeedService::class.java)


    }

}