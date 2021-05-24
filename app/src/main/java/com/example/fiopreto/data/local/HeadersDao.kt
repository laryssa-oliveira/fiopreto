package com.example.fiopreto.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface HeadersDao {

    @Insert
    suspend fun saveHeaders(headers: HeadersLocal)

    @Query("SELECT * FROM headers_table;")
    suspend fun getHeaders() : HeadersLocal
}