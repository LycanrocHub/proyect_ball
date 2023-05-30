package com.example.pikatech.data.models.pokemon.detallepoke


import com.squareup.moshi.Json

data class Other(
    @field:Json(name = "dream_world")
    val dreamWorld: DreamWorld?,
    @field:Json(name = "home")
    val home: Home?,
    @field:Json(name = "official-artwork")
    val officialArtwork: OfficialArtwork?
)