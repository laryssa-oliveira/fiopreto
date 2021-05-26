package com.example.fiopreto.data.local

import com.example.fiopreto.data.Constants.HEADER_ACCESS_TOKEN
import com.example.fiopreto.data.Constants.HEADER_AUTHORIZATION
import okhttp3.Headers

object LocalModelMappers {

    fun Headers.toLocalModel() =
        HeadersLocal(
            token = this[HEADER_ACCESS_TOKEN] ?: "",
            authorization = this[HEADER_AUTHORIZATION] ?: ""/*,
            client = this[HEADER_CLIENT] ?: "",
            uid = this[HEADER_UID] ?: ""*/

        )
    fun HeadersLocal.fromLocalModel() =
        Headers.Builder()
            .add(HEADER_ACCESS_TOKEN, token)
            .add(HEADER_AUTHORIZATION, authorization)
            //.add(HEADER_CLIENT, client)
            //.add(HEADER_UID, uid)
            .build()

}