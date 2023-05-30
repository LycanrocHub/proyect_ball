package com.example.pikatech.data.models.LocationsModels


import com.squareup.moshi.Json

data class locationData(
    @Json(name = "areas")
    val areas: List<Area?>?,
    @Json(name = "game_indices")
    val gameIndices: List<GameIndice?>?,
    @Json(name = "id")
    val id: Int?, // 1
    @Json(name = "name")
    val name: String?, // canalave-city
    @Json(name = "names")
    val names: List<Name?>?,
    @Json(name = "region")
    val region: Region?
)