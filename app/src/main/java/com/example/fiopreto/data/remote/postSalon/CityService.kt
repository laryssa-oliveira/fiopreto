package com.example.fiopreto.data.remote.postSalon
/*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import java.util.concurrent.TimeUnit

interface CityService {
    @GET("salon/city/")
    suspend fun getPostsSalon(

    ): Response<GetCitiesResponse>

    companion object {
        fun newInstance(client: OkHttpClient): CityService = Retrofit.Builder()
            .baseUrl("https://fiopreto.herokuapp.com/api/v1/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(CityService::class.java)
    }
}
/*
    @GET("post/")
    //Call<List<Cities>> populateList();
    suspend fun getPostsSaloon(
        @Header("Authorization") authorization: String,
        // @Header("client") client: String,
        // @Header("uid") uid: String
    ): Response<GetPostsSalonResponse>
    /*
    @Multipart // POST request to upload an image from storage
    @POST("fileUpload/")
    fun uploadImage(@Part image: Part?): Call<ResponseBody?>?*/

    companion object{
        fun newInstance(): SalonService = Retrofit.Builder()
            .baseUrl("https://fiopreto.herokuapp.com/api/v1/")
            .client(getClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(SalonService::class.java)

        private fun getClient(): OkHttpClient = OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }).build()

    }
}*/