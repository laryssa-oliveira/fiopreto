package com.example.fiopreto.data.remote.tips

import com.google.gson.annotations.SerializedName

data class UploadTipsResponse(
    @SerializedName("img")
    val imageUrl: String?
)

