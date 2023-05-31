package com.example.pikatech.data.models.ItemsModels2


import com.squareup.moshi.Json

data class ResultX(
    @Json(name = "name")
    val name: String?, // master-ball
    @Json(name = "url")
    val url: String? // https://pokeapi.co/api/v2/item/1/
)