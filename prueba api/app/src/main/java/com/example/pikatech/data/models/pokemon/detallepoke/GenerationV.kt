package com.example.pikatech.data.models.pokemon.detallepoke


import com.squareup.moshi.Json

data class GenerationV(
    @field:Json(name = "black-white")
    val blackWhite: BlackWhite?
)