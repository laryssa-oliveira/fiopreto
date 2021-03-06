package com.example.fiopreto.data.remote.postSalon

//import com.example.fiopreto.data.remote.postSalon.SalonRepositoryImpl.SessionManager.Companion.USER_TOKEN
import okhttp3.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface SalonService {
    @GET("salon/city/{ibge}")
    suspend fun getPostsSalon(
        @Path("ibge") ibge: Int?

    ): GetPostsSalonResponse

    companion object{
        fun newInstance(client: OkHttpClient): SalonService = Retrofit.Builder()
            .baseUrl("https://fiopreto.herokuapp.com/api/v1/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(SalonService::class.java)


                /*HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }).build()*/

        /*var client: OkHttpClient = Headers.Builder().addInterceptor(Interceptor { chain ->
            val newRequest: Request = chain.request().newBuilder()
                .addHeader("Authorization", "Bearer $it")
                .build()
            chain.proceed(newRequest)
        }).build()

        var retrofit: Retrofit = Retrofit.Builder()
            .client(client)
            .baseUrl("https://fiopreto.herokuapp.com/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()*/

    }
}