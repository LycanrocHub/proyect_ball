package com.example.pikatech.data

import android.content.Context
import com.example.pikatech.data.network.RetrofitHelper

class Repositorio(val context: Context) {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getItems() = retrofit.MostrarItems()
<<<<<<< HEAD
    suspend fun getItemIndividual(url: String)= retrofit.ObtenerItem(url)

    suspend fun getLocations() = retrofit.MostrarLocalizaciones()
    suspend fun getLocationIndividual(url: String)= retrofit.ObtenerLocalizaciones(url)
=======
    suspend fun getBayas() = retrofit.MostrarBayas()
    suspend fun getBayaIndividual(url: String)= retrofit.ObtenerBaya(url)

>>>>>>> 05dc43fac693782fc2affcf504f25dbd987070f2
}