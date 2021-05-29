package com.example.fiopreto.data.remote.postSalon

import com.google.gson.annotations.SerializedName

class AddressesResponse(
    @SerializedName("id")
    val id: Int,

    @SerializedName("zip")
    val zip: String,

    @SerializedName("district")
    val district: String,

    @SerializedName("street")
    val street: String,

    @SerializedName("number")
    val number: Int,

    @SerializedName("city")
    val city: String,

    @SerializedName("state")
    val state: String

)