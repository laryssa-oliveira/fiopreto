package com.example.fiopreto.injection

import com.example.fiopreto.data.remote.postsFeed.FeedService
import org.koin.dsl.module

val dataRemoteModule = module {

    single { FeedService.newInstance() }

}