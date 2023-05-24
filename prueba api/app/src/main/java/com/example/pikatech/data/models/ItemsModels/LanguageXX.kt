package com.example.pikatech.data.models.ItemsModels


import com.squareup.moshi.Json

data class LanguageXX(
    @Json(name = "name")
    val name: String?, // ja-Hrkt
    @Json(name = "url")
    val url: String? // https://pokeapi.co/api/v2/language/1/
)