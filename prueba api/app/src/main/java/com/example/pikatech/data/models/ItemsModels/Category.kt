package com.example.pikatech.data.models.ItemsModels


import com.squareup.moshi.Json

data class Category(
    @Json(name = "name")
    val name: String?, // standard-balls
    @Json(name = "url")
    val url: String? // https://pokeapi.co/api/v2/item-category/34/
)