package com.example.pikatech.data.models.bayas


import com.squareup.moshi.Json

data class NaturalGiftType(
    @Json(name = "name")
    val name: String?,
    @Json(name = "url")
    val url: String?
)