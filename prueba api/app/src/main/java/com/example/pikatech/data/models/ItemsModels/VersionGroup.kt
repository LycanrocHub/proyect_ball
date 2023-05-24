package com.example.pikatech.data.models.ItemsModels


import com.squareup.moshi.Json

data class VersionGroup(
    @Json(name = "name")
    val name: String?, // ruby-sapphire
    @Json(name = "url")
    val url: String? // https://pokeapi.co/api/v2/version-group/5/
)