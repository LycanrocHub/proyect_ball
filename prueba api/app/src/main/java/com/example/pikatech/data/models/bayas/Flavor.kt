package com.example.pikatech.data.models.bayas


import com.squareup.moshi.Json

data class Flavor(
    @Json(name = "flavor")
    val flavor: FlavorX?,
    @Json(name = "potency")
    val potency: Int?
)