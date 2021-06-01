package com.example.fiopreto

data class Cities(
    val city: String,
    val ibge: Int
){
    override fun toString(): String {
        return city
    }
}