package com.example.fiopreto.data.remote.postSalon

import com.google.gson.annotations.SerializedName

data class GetCityResponse (

    @SerializedName("data")
    val salonResp: List<SalonResponse>
)