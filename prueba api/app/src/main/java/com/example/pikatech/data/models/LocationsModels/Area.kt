package com.example.pikatech.data.models.LocationsModels


import com.squareup.moshi.Json

data class Area(
    @Json(name = "name")
    val name: String?, // canalave-city-area
    @Json(name = "url")
    val url: String? // https://pokeapi.co/api/v2/location-area/1/
)