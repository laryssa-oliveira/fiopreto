package com.example.fiopreto

data class PostFeed(
    val id: Int = 0,
    val user: User? = null,
    val pathImage: String? = ""
)

data class User(
    val name: String? = ""
)