package com.example.fiopreto.data.remote.tips

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header

interface TipsService {

    @GET("post/tips/")

    suspend fun getPostsTips(
        @Header("Authorization") auth: String,
        // @Header("client") client: String,
        // @Header("uid") uid: String
    ): GetPostsTipsResponse
    /*
    @Multipart // POST request to upload an image from storage
    @POST("fileUpload/")
    fun uploadImage(@Part image: Part?): Call<ResponseBody?>?*/

    companion object{
        fun newInstance(client: OkHttpClient): TipsService = Retrofit.Builder()
            .baseUrl("https://fiopreto.herokuapp.com/api/v1/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(TipsService::class.java)


    }
}

