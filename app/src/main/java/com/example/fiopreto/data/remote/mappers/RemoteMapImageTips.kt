package com.example.fiopreto.data.remote.mappers

import com.example.fiopreto.ImageTips
import com.example.fiopreto.data.remote.tips.UploadTipsResponse

fun UploadTipsResponse?.toModel(): ImageTips {
    return ImageTips(
        imageUrl = this?.imageUrl.orEmpty()
    )
}

