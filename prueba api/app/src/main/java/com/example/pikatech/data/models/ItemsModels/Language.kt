package com.example.pikatech.data.models.ItemsModels


import com.squareup.moshi.Json

data class Language(
    @Json(name = "name")
    val name: String?, // en
    @Json(name = "url")
    val url: String? // https://pokeapi.co/api/v2/language/9/
)