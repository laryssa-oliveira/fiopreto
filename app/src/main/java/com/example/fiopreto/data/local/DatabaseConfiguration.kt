package com.example.fiopreto.data.local

import android.content.Context
import androidx.room.Room

object DatabaseConfiguration {

    private var databaseInstance : PostsDatabase? = null

    fun getDatabaseInstance(context: Context) =
        if (databaseInstance == null) {
            createDatabase(context)
        } else
            databaseInstance!!

    private fun createDatabase(context: Context): PostsDatabase {
        databaseInstance = Room.databaseBuilder(
            context,
            PostsDatabase::class.java,
            "posts_database"
        ).build()
        return databaseInstance!!
    }

}