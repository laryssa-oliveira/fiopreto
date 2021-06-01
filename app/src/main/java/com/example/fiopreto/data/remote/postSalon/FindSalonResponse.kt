package com.example.fiopreto.data.remote.postSalon

import com.google.gson.annotations.SerializedName

data class FindSalonResponse(
    @SerializedName("city")
    val city: String,

    @SerializedName("ibge")
    val ibge: Int
)