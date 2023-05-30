package com.example.pikatech.data.models.LocationsModels


import com.squareup.moshi.Json

data class Generation(
    @Json(name = "name")
    val name: String?, // generation-iv
    @Json(name = "url")
    val url: String? // https://pokeapi.co/api/v2/generation/4/
)