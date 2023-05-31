package com.example.pikatech.data.models.pokemon.detallepoke


import com.squareup.moshi.Json

data class GenerationIi(
    @field:Json(name = "crystal")
    val crystal: Crystal?,
    @field:Json(name = "gold")
    val gold: Gold?,
    @field:Json(name = "silver")
    val silver: Silver?
)