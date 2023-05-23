package com.example.pikatech.data.models


import com.squareup.moshi.Json

data class PokemonLista(
    @Json(name = "count")
    val count: Int?,
    @Json(name = "next")
    val next: String?,
    @Json(name = "previous")
    val previous: Any?,
    @Json(name = "results")
    val results: List<Result?>?
)