package com.example.pikatech.data.models.pokemon.detallepoke


import com.squareup.moshi.Json

data class Stat(
    @field:Json(name = "base_stat")
    val baseStat: Int?,
    @field:Json(name = "effort")
    val effort: Int?,
    @field:Json(name = "stat")
    val stat: StatX?
)