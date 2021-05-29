package com.example.fiopreto.data.remote

//import com.example.fiopreto.Addresses
import com.example.fiopreto.PostSalon
import com.example.fiopreto.data.remote.postSalon.AddressesResponse
import com.example.fiopreto.data.remote.postSalon.SalonResponse

fun SalonResponse.toModel(): PostSalon {
    return PostSalon(
        id = id,
        name = name,
        site = site,
        pathImage = photo,
        //address = address.toModel()
    )
}

/*
fun AddressesResponse.toModel(): Addresses {
    return Addresses(
        id = id,
        zip = zip,
        district = district,
        street = street,
        number = number,
        city = city,
        state = state
    )
}*/