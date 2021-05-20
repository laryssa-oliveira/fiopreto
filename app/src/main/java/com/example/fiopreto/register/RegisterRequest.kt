package com.example.fiopreto.register

import com.google.gson.annotations.SerializedName

data class RegisterRequest (
    @SerializedName("name")
    val name: String,
    @SerializedName("dob")
    val  dob: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val  password: String
)