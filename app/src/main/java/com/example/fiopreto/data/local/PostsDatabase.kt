package com.example.fiopreto.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [HeadersLocal::class, PostsLocal::class],
    version = 1
)
abstract class PostsDatabase: RoomDatabase() {
    abstract fun provideHeadersDao(): HeadersDao

    abstract fun providePostsDao(): PostsDao
}