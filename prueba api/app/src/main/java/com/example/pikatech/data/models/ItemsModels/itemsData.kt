package com.example.pikatech.data.models.ItemsModels


import com.squareup.moshi.Json

data class itemsData(
    @Json(name = "attributes")
    val attributes: List<Attribute>?,
    @Json(name = "baby_trigger_for")
    val babyTriggerFor: Any?, // null
    @Json(name = "category")
    val category: Category?,
    @Json(name = "cost")
    val cost: Int?, // 0
    @Json(name = "effect_entries")
    val effectEntries: List<EffectEntry>?,
    @Json(name = "flavor_text_entries")
    val flavorTextEntries: List<FlavorTextEntry>?,
    @Json(name = "fling_effect")
    val flingEffect: Any?, // null
    @Json(name = "fling_power")
    val flingPower: Any?, // null
    @Json(name = "game_indices")
    val gameIndices: List<GameIndice>?,
    @Json(name = "held_by_pokemon")
    val heldByPokemon: List<Any>?,
    @Json(name = "id")
    val id: Int?, // 1
    @Json(name = "machines")
    val machines: List<Any>?,
    @Json(name = "name")
    val name: String?, // master-ball
    @Json(name = "names")
    val names: List<Name>?,
    @Json(name = "sprites")
    val sprites: Sprites?
)