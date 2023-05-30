package com.example.pikatech.data.models.bayas2


import com.squareup.moshi.Json

data class ResultX(
    @Json(name = "name")
    val name: String?,
    @Json(name = "url")
    val url: String?
)