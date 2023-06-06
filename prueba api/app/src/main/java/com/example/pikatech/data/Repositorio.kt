package com.example.pikatech.data

import android.content.Context
import com.example.pikatech.data.network.RetrofitHelper

class Repositorio(val context: Context) {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getItems() = retrofit.MostrarItems()
    suspend fun getItemIndividual(url: String)= retrofit.ObtenerItem(url)
    suspend fun getPokemon(offset: Int, limit: Int) = retrofit.MostrarPokemon(offset, limit)
    suspend fun getPokemonIndividual(url: String) = retrofit.ObtenerPokemon(url)

    suspend fun getDatosMovimiento(url: String) = retrofit.ObtenerMovimiento(url)

    suspend fun getLocations() = retrofit.MostrarLocalizaciones()
    suspend fun getLocationIndividual(url: String)= retrofit.ObtenerLocalizaciones(url)
    suspend fun getBayas() = retrofit.MostrarBayas()
    suspend fun getBayaIndividual(url: String)= retrofit.ObtenerBaya(url)

}