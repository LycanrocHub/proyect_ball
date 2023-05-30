package com.example.pikatech.data.models.pokemon.detallepoke


import com.squareup.moshi.Json

data class UltraSunUltraMoon(
    @field:Json(name = "front_default")
    val frontDefault: String?,
    @field:Json(name = "front_female")
    val frontFemale: Any?,
    @field:Json(name = "front_shiny")
    val frontShiny: String?,
    @field:Json(name = "front_shiny_female")
    val frontShinyFemale: Any?
)