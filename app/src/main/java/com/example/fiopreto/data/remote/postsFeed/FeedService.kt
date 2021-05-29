package com.example.fiopreto.data.remote.postsFeed

import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import java.util.concurrent.TimeUnit


interface FeedService {

    @GET("post/")

    suspend fun getPostsFeed(
        @Header("Authorization") authorization: String,
       // @Header("client") client: String,
       // @Header("uid") uid: String
    ): Response<GetPostsFeedResponse>
    /*
    @Multipart // POST request to upload an image from storage
    @POST("fileUpload/")
    fun uploadImage(@Part image: Part?): Call<ResponseBody?>?*/

    companion object{
        fun newInstance(client: OkHttpClient): FeedService = Retrofit.Builder()
            .baseUrl("https://fiopreto.herokuapp.com/api/v1/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(FeedService::class.java)


    }
}