package com.example.fiopreto.data.remote.mappers

import com.example.fiopreto.PostTips
import com.example.fiopreto.UserTips
import com.example.fiopreto.data.remote.tips.TipsResponse
import com.example.fiopreto.data.remote.tips.UserResponseTips


fun TipsResponse.toModel(): PostTips {
    return PostTips(
        id = id,
        text = text,
        userTips = userTips?.toModel(),
        pathImageTips = photo
    )
}

fun UserResponseTips.toModel(): UserTips {
    return UserTips(
        name = name
    )
}

