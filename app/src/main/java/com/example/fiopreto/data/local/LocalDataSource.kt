package com.example.fiopreto.data.local

import okhttp3.Headers

interface LocalDataSource {

    suspend fun saveToLocalDatabase(headers: Headers)

    suspend fun getFromLocalDatabase() : Headers

    fun saveHeadersToPreferences(headers: Headers)

    fun getHeadersFromPreferences() : Headers
}