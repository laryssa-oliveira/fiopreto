package com.example.fiopreto

import android.app.Application
import com.example.fiopreto.injection.dataLocalModule
import com.example.fiopreto.injection.dataModule
import com.example.fiopreto.injection.dataRemoteModule
import com.example.fiopreto.injection.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PostsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            androidContext(this@PostsApplication)
            modules(listOf(
                presentationModule,
                dataModule,
                dataLocalModule,
                dataRemoteModule
            )
            )
        }
    }
}