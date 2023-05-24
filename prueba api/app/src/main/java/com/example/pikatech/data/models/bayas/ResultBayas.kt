package com.example.pikatech.data.models.bayas


import com.squareup.moshi.Json

data class ResultBayas(
    @Json(name = "firmness")
    val firmness: Firmness?,
    @Json(name = "flavors")
    val flavors: List<Flavor>?,
    @Json(name = "growth_time")
    val growthTime: Int?,
    @Json(name = "id")
    val id: Int?,
    @Json(name = "item")
    val item: Item?,
    @Json(name = "max_harvest")
    val maxHarvest: Int?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "natural_gift_power")
    val naturalGiftPower: Int?,
    @Json(name = "natural_gift_type")
    val naturalGiftType: NaturalGiftType?,
    @Json(name = "size")
    val size: Int?,
    @Json(name = "smoothness")
    val smoothness: Int?,
    @Json(name = "soil_dryness")
    val soilDryness: Int?
)