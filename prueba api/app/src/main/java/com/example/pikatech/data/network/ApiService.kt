package com.example.pikatech.data.network

import com.example.pikatech.data.models.ItemsModels.itemsData
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    //conseguir listado de items
    @GET("item")
    suspend fun MostrarItems(): Response<List<itemsData>>


}