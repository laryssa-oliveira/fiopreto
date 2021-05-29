package com.example.fiopreto.data.remote.postsFeed

import com.google.gson.annotations.SerializedName

data class UploadFeedResponse(
    @SerializedName("url")
    val imageUrl: String
)