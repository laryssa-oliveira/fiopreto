package com.example.fiopreto.extensions

import com.example.fiopreto.ResultWrapper
import com.example.fiopreto.ResultWrapper.*
import retrofit2.Response

suspend fun <T> wrapResponse(
    call: suspend () -> Response<T>

): ResultWrapper<T> {
    val result = call()
    return try {
        Success(result.body()!!)
    } catch (error: Throwable){
        Failure(error)
    }
}
