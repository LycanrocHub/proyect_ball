package com.example.pikatech.data.models.LocationsModels


import com.squareup.moshi.Json

data class GameIndice(
    @Json(name = "game_index")
    val gameIndex: Int?, // 7
    @Json(name = "generation")
    val generation: Generation?
)