package com.example.fiopreto.data

import com.example.fiopreto.PostFeed
import com.example.fiopreto.data.remote.ResultWrapper

interface FeedRepository {
    suspend fun getPostsFeed() : ResultWrapper<List<PostFeed>>
}