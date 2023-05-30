package com.example.pikatech.data.models.LocationsModels


import com.squareup.moshi.Json

data class Region(
    @Json(name = "name")
    val name: String?, // sinnoh
    @Json(name = "url")
    val url: String? // https://pokeapi.co/api/v2/region/4/
)