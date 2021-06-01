package com.example.fiopreto.data.remote

import com.example.fiopreto.PostFeed
import com.example.fiopreto.User
import com.example.fiopreto.data.remote.postsFeed.FeedResponse
import com.example.fiopreto.data.remote.postsFeed.UserResponse

fun FeedResponse.toModel(): PostFeed {
    return PostFeed(
        id = id,
        user = user?.toModel(),
        pathImage = photo
    )
}

fun UserResponse.toModel(): User{
    return User(
        name = name
    )
}


