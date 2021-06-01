package com.example.fiopreto.data.remote

sealed class ResultWrapper<out B>{

    data class Success<out T>(val data: T) : ResultWrapper<T>()
    data class Failure(val error: Throwable) : ResultWrapper<Nothing>()
}