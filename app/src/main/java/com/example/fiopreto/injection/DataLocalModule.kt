package com.example.fiopreto.injection

import android.content.Context
import com.example.fiopreto.data.Constants
import com.example.fiopreto.data.local.DatabaseConfiguration
import com.example.fiopreto.data.local.LocalDataSource
import com.example.fiopreto.data.local.LocalDataSourceImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataLocalModule = module {

    fun provideSharedPreferences(context: Context) =
        context.getSharedPreferences(
            Constants.SHARED_PREF_FILE,
            Context.MODE_PRIVATE
        )

    single<LocalDataSource> { LocalDataSourceImpl(get(),get()) }

    single { provideSharedPreferences(androidContext()) }

    single {
        DatabaseConfiguration
            .getDatabaseInstance(androidContext())
            .provideHeadersDao()

    }
}
