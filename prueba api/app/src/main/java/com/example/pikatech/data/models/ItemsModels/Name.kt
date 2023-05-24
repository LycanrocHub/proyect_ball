package com.example.pikatech.data.models.ItemsModels


import com.squareup.moshi.Json

data class Name(
    @Json(name = "language")
    val language: LanguageXX?,
    @Json(name = "name")
    val name: String? // マスターボール
)