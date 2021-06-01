package com.example.fiopreto.injection

import com.example.fiopreto.data.*
import com.example.fiopreto.data.remote.login.LoginRepositoryImpl
import com.example.fiopreto.data.remote.postSalon.FindSalonRepositoryImpl
import com.example.fiopreto.data.remote.postsFeed.FeedRepositoryImpl
import com.example.fiopreto.data.remote.postSalon.SalonRepositoryImpl
import com.example.fiopreto.data.remote.postsFeed.UploadFeedRepositoryImpl
import com.example.fiopreto.data.remote.tips.TipsRepositoryImpl
import com.example.fiopreto.data.remote.tips.UploadTipsRepositoryImpl
import com.example.fiopreto.data.TipsRepository
import com.example.fiopreto.data.repository.UploadTipsRepository
import org.koin.dsl.module

val dataModule = module {
    single<FeedRepository> { FeedRepositoryImpl(get(),get()) }
    single<SalonRepository> { SalonRepositoryImpl(get())}
    single<LoginRepository> { LoginRepositoryImpl(get(),get())}
    single<UploadFeedRepository> { UploadFeedRepositoryImpl(get()) }
    single<FindSalonRepository> { FindSalonRepositoryImpl(get(),get()) }
    single<TipsRepository> { TipsRepositoryImpl(get(),get()) }
    single<UploadTipsRepository> { UploadTipsRepositoryImpl(get()) }

}