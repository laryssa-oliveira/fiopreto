package com.example.fiopreto.data.remote

import com.example.fiopreto.ImageFeed
import com.example.fiopreto.data.remote.postsFeed.UploadFeedResponse

fun UploadFeedResponse?.toModel(): ImageFeed{
    return ImageFeed(
        imageUrl = this?.imageUrl.orEmpty()
    )
}