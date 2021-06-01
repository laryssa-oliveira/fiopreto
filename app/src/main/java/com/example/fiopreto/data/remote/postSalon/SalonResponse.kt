package com.example.fiopreto.data.remote.postSalon

import com.google.gson.annotations.SerializedName

data class SalonResponse (

    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("phone")
    val phone: String,

    @SerializedName("site")
    val site: String,

    @SerializedName("img")
    val photo: String,

    @SerializedName("addresses")
    val address: AddressesResponse
)