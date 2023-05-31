package com.example.pikatech.data.models.ItemsModels2



import com.squareup.moshi.Json

data class items(
    @Json(name = "count")
    val count: Int?, // 2050
    @Json(name = "next")
    val next: String?, // https://pokeapi.co/api/v2/item?offset=20&limit=20
    @Json(name = "previous")
    val previous: Any?, // null
    @Json(name = "results")
    val results: List<ResultX>?
)