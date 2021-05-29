package com.example.fiopreto.data.remote.login

import com.google.gson.annotations.SerializedName

data class LoginResponse (

    @SerializedName("token")
    val token: String
)