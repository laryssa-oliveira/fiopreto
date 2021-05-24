package com.example.fiopreto.injection

import com.example.fiopreto.data.FeedRepository
import com.example.fiopreto.data.remote.postsFeed.FeedRepositoryImpl
import org.koin.dsl.module

val dataModule = module {
    single<FeedRepository> { FeedRepositoryImpl(get(),get()) }
}