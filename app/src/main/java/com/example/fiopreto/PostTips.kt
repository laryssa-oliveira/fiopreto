package com.example.fiopreto
data class PostTips(
    val id: Int = 0,
    val text: String? = "",
    val userTips: UserTips? = null,
    val pathImageTips: String? = ""
)

data class UserTips(
    val name: String? = ""
)