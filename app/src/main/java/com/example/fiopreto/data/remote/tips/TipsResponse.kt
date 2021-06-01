package com.example.fiopreto.data.remote.tips

import com.google.gson.annotations.SerializedName

class TipsResponse (

    @SerializedName("id")
    val id: Int,

    @SerializedName("img")
    val photo: String,

    @SerializedName("text")
    val text: String,

    @SerializedName("posts")
    val userTips: UserResponseTips

)

