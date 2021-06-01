package com.example.fiopreto.data.remote.tips

import com.google.gson.annotations.SerializedName

data class GetPostsTipsResponse (

    @SerializedName("data")
    val tipsResp: List<TipsResponse>
)
