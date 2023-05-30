package com.example.pikatech.data.network

import com.example.pikatech.data.models.ItemsModels.itemsData
import com.example.pikatech.data.models.ItemsModels2.items
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {

    //conseguir listado de items
    @GET("item")
    suspend fun MostrarItems(): Response<items>

    @GET()
    suspend fun ObtenerItem(@Url url: String): Response<itemsData>


}