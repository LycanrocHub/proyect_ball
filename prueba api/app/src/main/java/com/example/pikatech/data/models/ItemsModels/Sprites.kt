package com.example.pikatech.data.models.ItemsModels


import com.squareup.moshi.Json

data class Sprites(
    @Json(name = "default")
    val default: String? // https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/items/master-ball.png
)