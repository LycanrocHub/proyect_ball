package com.example.pikatech.data

import android.content.Context
import com.example.pikatech.data.network.RetrofitHelper

class Repositorio(val context: Context) {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getItems() = retrofit.MostrarItems()
    suspend fun getItemIndividual(url: String)= retrofit.ObtenerItem(url)

    suspend fun getLocations() = retrofit.MostrarLocalizaciones()
    suspend fun getLocationIndividual(url: String)= retrofit.ObtenerLocalizaciones(url)
    suspend fun getBayas() = retrofit.MostrarBayas()
    suspend fun getBayaIndividual(url: String)= retrofit.ObtenerBaya(url)

}