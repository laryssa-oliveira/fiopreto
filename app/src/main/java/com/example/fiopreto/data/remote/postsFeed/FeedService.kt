package com.example.fiopreto.data.remote.postsFeed

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import java.util.concurrent.TimeUnit

interface FeedService {

    @GET("image/")
    suspend fun getPostsFeed(
        @Header("access-token") accessToken: String,
       // @Header("client") client: String,
       // @Header("uid") uid: String
    ): Response<GetPostsFeedResponse>

    companion object{
        fun newInstance(): FeedService = Retrofit.Builder()
            .baseUrl("https://fiopreto.herokuapp.com/api/v1/")
            .client(getClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(FeedService::class.java)

        private fun getClient(): OkHttpClient = OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }).build()

    }
}