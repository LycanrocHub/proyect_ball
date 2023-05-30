package com.example.pikatech.data.models.pokemon.detallepoke


import com.squareup.moshi.Json

data class GenerationVi(
    @field:Json(name = "omegaruby-alphasapphire")
    val omegarubyAlphasapphire: OmegarubyAlphasapphire?,
    @field:Json(name = "x-y")
    val xY: XY?
)