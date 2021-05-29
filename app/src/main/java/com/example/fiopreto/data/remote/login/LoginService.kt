package com.example.fiopreto.data.remote.login

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import java.util.concurrent.TimeUnit


interface LoginService {

    @POST("auth/signin")

    suspend fun login(
        @Body loginRequest: LoginRequest
    ): Response<LoginResponse>

    companion object{
        fun newInstance(): LoginService = Retrofit.Builder()
            .baseUrl("https://fiopreto.herokuapp.com/api/v1/")
            .client(getClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(LoginService::class.java)

        private fun getClient(): OkHttpClient = OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }).build()

    }


}