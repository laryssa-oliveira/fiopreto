package com.example.fiopreto.data.remote.postSalon

import com.google.gson.annotations.SerializedName

data class GetPostsSalonResponse (

    @SerializedName("data")
    val salonResp: List<SalonResponse>
)