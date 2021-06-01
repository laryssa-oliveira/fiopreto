package com.example.fiopreto.data

import com.example.fiopreto.data.remote.ResultWrapper
import com.example.fiopreto.Cities

interface FindSalonRepository {
    suspend fun getCities() : ResultWrapper<List<Cities>>
}