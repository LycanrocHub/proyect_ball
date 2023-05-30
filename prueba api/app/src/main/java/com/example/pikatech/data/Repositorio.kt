package com.example.pikatech.data

import android.content.Context
import com.example.pikatech.data.network.RetrofitHelper

class Repositorio(val context: Context) {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getItems() = retrofit.MostrarItems()
    suspend fun getItemIndividual(url: String)= retrofit.ObtenerItem(url)
}