package com.example.pikatech.data.models.ItemsModels


import com.squareup.moshi.Json

data class GameIndice(
    @Json(name = "game_index")
    val gameIndex: Int?, // 1
    @Json(name = "generation")
    val generation: Generation?
)