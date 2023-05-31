package com.example.pikatech.data.models.pokemon.detallepoke


import com.squareup.moshi.Json

data class GenerationI(
    @field:Json(name = "red-blue")
    val redBlue: RedBlue?,
    @field:Json(name = "yellow")
    val yellow: Yellow?
)