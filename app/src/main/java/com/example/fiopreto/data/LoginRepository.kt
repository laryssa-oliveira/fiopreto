package com.example.fiopreto.data
import com.example.fiopreto.data.remote.ResultWrapper
import com.example.fiopreto.data.remote.login.LoginResponse
import okhttp3.Headers

interface LoginRepository {
    suspend fun login(email: String, password: String) : ResultWrapper<LoginResponse>
}