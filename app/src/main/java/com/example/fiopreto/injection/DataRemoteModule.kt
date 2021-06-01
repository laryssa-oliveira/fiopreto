package com.example.fiopreto.injection

import com.example.fiopreto.data.local.LocalDataSource
import com.example.fiopreto.data.remote.login.LoginService

import com.example.fiopreto.data.remote.postSalon.FindSalonService
import com.example.fiopreto.data.remote.postsFeed.FeedService
import com.example.fiopreto.data.remote.postSalon.SalonService
import com.example.fiopreto.data.remote.postsFeed.UploadFeedService
import com.example.fiopreto.data.remote.tips.TipsService
import com.example.fiopreto.data.remote.tips.UploadTipsService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import java.util.concurrent.TimeUnit

val dataRemoteModule = module {

    single { FeedService.newInstance(get()) }
    single { SalonService.newInstance(get()) }
    single { LoginService.newInstance() }
    single { UploadFeedService.newInstance(get()) }
    single<OkHttpClient> { getClient(get()) }
    single { FindSalonService.newInstance(get()) }
    single { TipsService.newInstance(get()) }
    single { UploadTipsService.newInstance(get()) }

}

private fun getClient(localDataSource: LocalDataSource): OkHttpClient = OkHttpClient.Builder()
    .readTimeout(60, TimeUnit.SECONDS)
    .connectTimeout(60, TimeUnit.SECONDS)
    .addInterceptor(
        Interceptor { chain ->
            val newRequest: Request = chain.request().newBuilder()
                .headers(localDataSource.getHeadersFromPreferences())
                .build()
            chain.proceed(newRequest)
        }).addInterceptor(HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }).build()