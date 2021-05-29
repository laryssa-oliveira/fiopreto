package com.example.fiopreto.injection

import com.example.fiopreto.data.FeedRepository
import com.example.fiopreto.data.LoginRepository
import com.example.fiopreto.data.SalonRepository
import com.example.fiopreto.data.UploadFeedRepository
import com.example.fiopreto.data.remote.login.LoginRepositoryImpl
import com.example.fiopreto.data.remote.postsFeed.FeedRepositoryImpl
import com.example.fiopreto.data.remote.postSalon.SalonRepositoryImpl
import com.example.fiopreto.data.remote.postsFeed.UploadFeedRepositoryImpl
import org.koin.dsl.module

val dataModule = module {
    single<FeedRepository> { FeedRepositoryImpl(get(),get()) }
    single<SalonRepository> { SalonRepositoryImpl(get(),get())}
    single<LoginRepository> { LoginRepositoryImpl(get(),get())}
    single<UploadFeedRepository> { UploadFeedRepositoryImpl(get()) }
}