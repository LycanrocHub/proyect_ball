package com.example.pikatech.data.models.ItemsModels


import com.squareup.moshi.Json

data class FlavorTextEntry(
    @Json(name = "language")
    val language: Language?,
    @Json(name = "text")
    val text: String?, // The best BALL thatcatches a POKéMONwithout fail.
    @Json(name = "version_group")
    val versionGroup: VersionGroup?
)