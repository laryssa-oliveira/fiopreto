package com.example.fiopreto.data

import com.example.fiopreto.PostTips
import com.example.fiopreto.data.remote.ResultWrapper

interface TipsRepository {
    suspend fun getPostsTips() : ResultWrapper<List<PostTips>>
}
