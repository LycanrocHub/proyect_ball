package com.example.pikatech.data.models.pokemon.detallepoke


import com.squareup.moshi.Json

data class Ability(
    @field:Json(name = "ability")
    val ability: AbilityX?,
    @field:Json(name = "is_hidden")
    val isHidden: Boolean?,
    @Json(name = "slot")
    val slot: Int?
)