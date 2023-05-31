package com.example.pikatech.data.models.pokemon.detallepoke


import com.squareup.moshi.Json

data class GameIndice(
    @field:Json(name = "game_index")
    val gameIndex: Int?,
    @field:Json(name = "version")
    val version: Version?
)