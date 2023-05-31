package com.example.pikatech.data.models.pokemon


import com.squareup.moshi.Json

data class Result(
    @field:Json(name = "name")
    val name: String?,
    @field:Json(name = "url")
    val url: String?,
    var id: Int
)