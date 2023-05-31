package com.example.pikatech.data.models.pokemon.detallepoke


import com.squareup.moshi.Json

data class Crystal(
    @field:Json(name = "back_default")
    val backDefault: String?,
    @field:Json(name = "back_shiny")
    val backShiny: String?,
    @field:Json(name = "back_shiny_transparent")
    val backShinyTransparent: String?,
    @field:Json(name = "back_transparent")
    val backTransparent: String?,
    @field:Json(name = "front_default")
    val frontDefault: String?,
    @field:Json(name = "front_shiny")
    val frontShiny: String?,
    @field:Json(name = "front_shiny_transparent")
    val frontShinyTransparent: String?,
    @field:Json(name = "front_transparent")
    val frontTransparent: String?
)