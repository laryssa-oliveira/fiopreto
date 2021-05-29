package com.example.fiopreto.data

import com.example.fiopreto.PostSalon
import com.example.fiopreto.data.remote.ResultWrapper

interface SalonRepository {
    suspend fun getPostsSalon() : ResultWrapper<List<PostSalon>>
}