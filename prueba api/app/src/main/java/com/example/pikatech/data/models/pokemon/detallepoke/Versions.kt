package com.example.pikatech.data.models.pokemon.detallepoke


import com.squareup.moshi.Json

data class Versions(
    @field:Json(name = "generation-i")
    val generationI: GenerationI?,
    @field:Json(name = "generation-ii")
    val generationIi: GenerationIi?,
    @field:Json(name = "generation-iii")
    val generationIii: GenerationIii?,
    @field:Json(name = "generation-iv")
    val generationIv: GenerationIv?,
    @field:Json(name = "generation-v")
    val generationV: GenerationV?,
    @field:Json(name = "generation-vi")
    val generationVi: GenerationVi?,
    @field:Json(name = "generation-vii")
    val generationVii: GenerationVii?,
    @field:Json(name = "generation-viii")
    val generationViii: GenerationViii?
)