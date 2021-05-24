package com.example.fiopreto.data.remote.postsFeed

import com.google.gson.annotations.SerializedName

data class FeedResponse (

    @SerializedName("id")
    val id: Int,

    //@SerializedName("enterprise_name")
    //val enterpriseName: String,

    @SerializedName("image")
    val photo: String,

    /*

    @SerializedName("description")
    val description: String,

    @SerializedName("city")
    val city: String? = null,

    @SerializedName("country")
    val country: String? = null,

    @SerializedName("enterprise_type")
    val enterpriseType: CompanyTypeResponse*/
)