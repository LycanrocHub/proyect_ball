package com.example.pikatech.data.models.ItemsModels


import com.squareup.moshi.Json

data class Attribute(
    @Json(name = "name")
    val name: String?, // countable
    @Json(name = "url")
    val url: String? // https://pokeapi.co/api/v2/item-attribute/1/
)