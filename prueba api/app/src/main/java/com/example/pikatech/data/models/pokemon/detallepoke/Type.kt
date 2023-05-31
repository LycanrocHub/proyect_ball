package com.example.pikatech.data.models.pokemon.detallepoke


import com.squareup.moshi.Json

data class Type(
    @field:Json(name = "slot")
    val slot: Int?,
    @field:Json(name = "type")
    val type: TypeX?
)