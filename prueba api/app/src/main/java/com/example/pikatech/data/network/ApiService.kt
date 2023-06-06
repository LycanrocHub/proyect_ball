package com.example.pikatech.data.network

import com.example.pikatech.data.models.ItemsModels.itemsData
import com.example.pikatech.data.models.ItemsModels2.items
import com.example.pikatech.data.models.LocationsModels.locationData
import com.example.pikatech.data.models.LocationsModels2.Locations
import com.example.pikatech.data.models.bayas.ResultBayas
import com.example.pikatech.data.models.bayas2.BayaRes
import com.example.pikatech.data.models.pokemon.ListadoPokemon
import com.example.pikatech.data.models.pokemon.detallemovimiento.RespuestaMovimiento
import com.example.pikatech.data.models.pokemon.detallepoke.RespuestaPokemon
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface ApiService {

    //conseguir listado de items
    @GET("item")
    suspend fun MostrarItems(): Response<items>

    @GET()
    suspend fun ObtenerItem(@Url url: String): Response<itemsData>

    @GET("pokemon")
    suspend fun MostrarPokemon(@Query("offset") offset: Int, @Query("limit") limit: Int): Response<ListadoPokemon>

    @GET()
    suspend fun ObtenerPokemon(@Url url: String): Response<RespuestaPokemon>

    @GET()
    suspend fun ObtenerMovimiento(@Url url: String): Response<RespuestaMovimiento>

    //conseguir listado de localizaciones
    @GET("location")
    suspend fun MostrarLocalizaciones(): Response<Locations>

    @GET()
    suspend fun ObtenerLocalizaciones(@Url url: String): Response<locationData>
    @GET("berry")
    suspend fun MostrarBayas(): Response<BayaRes>

    @GET()
    suspend fun ObtenerBaya(@Url url: String): Response<ResultBayas>

}