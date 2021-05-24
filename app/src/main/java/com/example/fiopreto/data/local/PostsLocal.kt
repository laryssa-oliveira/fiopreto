package com.example.fiopreto.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "posts_table")
data class PostsLocal (
    @PrimaryKey var  id: Int
)