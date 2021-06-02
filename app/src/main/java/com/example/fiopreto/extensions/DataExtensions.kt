package com.example.fiopreto.extensions

import com.example.fiopreto.data.remote.ResultWrapper
import com.example.fiopreto.data.remote.ResultWrapper.*
import com.example.fiopreto.data.remote.postsFeed.UploadFeedResponse
import retrofit2.Response


suspend fun <T> wrapResponse(
    call: suspend () -> T

): ResultWrapper<T> {

    return try {
        val result = call()
        Success(result)
    } catch (error: Throwable){
        Failure(error)
    }
}
