package com.example.pikatech.data.models.pokemon.detallepoke


import com.squareup.moshi.Json

data class RedBlue(
    @field:Json(name = "back_default")
    val backDefault: String?,
    @field:Json(name = "back_gray")
    val backGray: String?,
    @field:Json(name = "back_transparent")
    val backTransparent: String?,
    @field:Json(name = "front_default")
    val frontDefault: String?,
    @field:Json(name = "front_gray")
    val frontGray: String?,
    @field:Json(name = "front_transparent")
    val frontTransparent: String?
)