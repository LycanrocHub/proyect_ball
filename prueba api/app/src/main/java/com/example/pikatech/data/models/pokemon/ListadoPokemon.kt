package com.example.pikatech.data.models.pokemon


import com.squareup.moshi.Json

data class ListadoPokemon(
    @field:Json(name = "count")
    val count: Int?,
    @field:Json(name = "next")
    val next: String?,
    @field:Json(name = "previous")
    val previous: Any?,
    @field:Json(name = "results")
    val results: List<Result>?
)