package com.example.pikatech.data.models.pokemon.detallepoke


import com.squareup.moshi.Json

data class RespuestaPokemon(
    @field:Json(name = "abilities")
    val abilities: List<Ability>?,
    @field:Json(name = "base_experience")
    val baseExperience: Int?,
    @field:Json(name = "forms")
    val forms: List<Form>?,
    @field:Json(name = "game_indices")
    val gameIndices: List<GameIndice>?,
    @field:Json(name = "height")
    val height: Int?,
    @field:Json(name = "held_items")
    val heldItems: List<Any>?,
    @field:Json(name = "id")
    val id: Int?,
    @field:Json(name = "is_default")
    val isDefault: Boolean?,
    @field:Json(name = "location_area_encounters")
    val locationAreaEncounters: String?,
    @field:Json(name = "moves")
    val moves: List<Move>?,
    @field:Json(name = "name")
    val name: String?,
    @field:Json(name = "order")
    val order: Int?,
    @field:Json(name = "past_types")
    val pastTypes: List<Any>?,
    @field:Json(name = "species")
    val species: Species?,
    @field:Json(name = "sprites")
    val sprites: Sprites?,
    @field:Json(name = "stats")
    val stats: List<Stat>?,
    @field:Json(name = "types")
    val types: List<Type>?,
    @field:Json(name = "weight")
    val weight: Int?
)