package com.example.pikatech.data.models.pokemon.detallepoke


import com.squareup.moshi.Json

data class Move(
    @field:Json(name = "move")
    val move: MoveX?,
    @field:Json(name = "version_group_details")
    val versionGroupDetails: List<VersionGroupDetail>?
)