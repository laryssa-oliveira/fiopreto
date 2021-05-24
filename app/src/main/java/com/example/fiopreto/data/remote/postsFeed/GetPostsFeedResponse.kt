package com.example.fiopreto.data.remote.postsFeed

import com.google.gson.annotations.SerializedName


data class GetPostsFeedResponse (

    @SerializedName("posts")
    val feedResp: List<FeedResponse>
)