package com.example.fiopreto.data.remote

import com.example.fiopreto.PostFeed
import com.example.fiopreto.data.remote.postsFeed.FeedResponse

fun FeedResponse.toModel(): PostFeed {
    return PostFeed(
        id = id,
        name = name,
        pathImage = photo
    )
}
