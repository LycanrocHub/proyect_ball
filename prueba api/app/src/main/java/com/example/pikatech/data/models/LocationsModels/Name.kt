package com.example.pikatech.data.models.LocationsModels


import com.squareup.moshi.Json

data class Name(
    @Json(name = "language")
    val language: Language?,
    @Json(name = "name")
    val name: String? // Joliberges
)