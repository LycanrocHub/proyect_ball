package com.example.pikatech.data.models.pokemon.detallepoke


import com.squareup.moshi.Json

data class GenerationIii(
    @field:Json(name = "emerald")
    val emerald: Emerald?,
    @field:Json(name = "firered-leafgreen")
    val fireredLeafgreen: FireredLeafgreen?,
    @field:Json(name = "ruby-sapphire")
    val rubySapphire: RubySapphire?
)