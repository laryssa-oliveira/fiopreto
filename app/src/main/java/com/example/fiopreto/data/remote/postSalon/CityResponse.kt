package com.example.fiopreto.data.remote.postSalon

import com.google.gson.annotations.SerializedName

class CityResponse (
    @SerializedName("id")
    val id: Int,

    @SerializedName("list")
    val list: List<Cities>
)