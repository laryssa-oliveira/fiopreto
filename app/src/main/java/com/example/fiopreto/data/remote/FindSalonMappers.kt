package com.example.fiopreto.data.remote

import com.example.fiopreto.Cities
import com.example.fiopreto.data.remote.postSalon.FindSalonResponse

fun FindSalonResponse.toModel(): Cities {
    return Cities(
        city = city,
        ibge = ibge
    )
}