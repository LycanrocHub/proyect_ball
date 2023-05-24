package com.example.pikatech.data.models.ItemsModels


import com.squareup.moshi.Json

data class Generation(
    @Json(name = "name")
    val name: String?, // generation-iii
    @Json(name = "url")
    val url: String? // https://pokeapi.co/api/v2/generation/3/
)