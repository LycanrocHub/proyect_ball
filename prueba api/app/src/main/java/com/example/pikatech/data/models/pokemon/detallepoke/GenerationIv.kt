package com.example.pikatech.data.models.pokemon.detallepoke


import com.squareup.moshi.Json

data class GenerationIv(
    @field:Json(name = "diamond-pearl")
    val diamondPearl: DiamondPearl?,
    @field:Json(name = "heartgold-soulsilver")
    val heartgoldSoulsilver: HeartgoldSoulsilver?,
    @field:Json(name = "platinum")
    val platinum: Platinum?
)