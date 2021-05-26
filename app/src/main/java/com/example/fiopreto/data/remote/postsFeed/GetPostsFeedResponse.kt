package com.example.fiopreto.data.remote.postsFeed

import com.google.gson.annotations.SerializedName


data class GetPostsFeedResponse (

    @SerializedName("data")
    val feedResp: List<FeedResponse>
)