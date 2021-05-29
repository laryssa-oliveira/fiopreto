package com.example.fiopreto.data.remote.login

import com.example.fiopreto.data.Constants.HEADER_ACCESS_TOKEN
import com.example.fiopreto.data.LoginRepository
import com.example.fiopreto.data.local.LocalDataSource
import com.example.fiopreto.extensions.wrapResponse
import okhttp3.Headers


class LoginRepositoryImpl(
    private val loginService: LoginService,
    private val localDataSource: LocalDataSource
) : LoginRepository {

    override suspend fun login(email: String, password: String) =
        wrapResponse{
            loginService.login(
                LoginRequest(
                    email = email,
                    password = password
                )
            ).apply {
                localDataSource.saveHeadersToPreferences(Headers.Builder()
                    .add("Authorization","Bearer "+ this.body()?.token.orEmpty()).build())
            }
        }

}