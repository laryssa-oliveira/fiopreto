package com.example.fiopreto.data.remote.postSalon

import com.example.fiopreto.data.remote.postsFeed.FeedService
import com.example.fiopreto.data.remote.postsFeed.GetPostsFeedResponse
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header

interface FindSalonService {

    @GET("salon/city/")

    suspend fun getCities(
        @Header("Authorization") authorization: String,
        // @Header("client") client: String,
        // @Header("uid") uid: String
    ): GetCityResponse
    /*
    @Multipart // POST request to upload an image from storage
    @POST("fileUpload/")
    fun uploadImage(@Part image: Part?): Call<ResponseBody?>?*/

    companion object{
        fun newInstance(client: OkHttpClient): FindSalonService = Retrofit.Builder()
            .baseUrl("https://fiopreto.herokuapp.com/api/v1/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(FindSalonService::class.java)


    }
}