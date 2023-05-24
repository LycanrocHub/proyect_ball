package com.example.pikatech.data.models.ItemsModels


import com.squareup.moshi.Json

data class EffectEntry(
    @Json(name = "effect")
    val effect: String?, // Used in battle:   Catches a wild Pokémon without fail.    If used in a trainer battle, nothing happens and the ball is lost.
    @Json(name = "language")
    val language: Language?,
    @Json(name = "short_effect")
    val shortEffect: String? // Catches a wild Pokémon every time.
)