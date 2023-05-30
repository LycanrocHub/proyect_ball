package com.example.pikatech.data.network

import com.example.pikatech.data.models.ItemsModels.itemsData
import com.example.pikatech.data.models.bayas.ResultBayas
import com.example.pikatech.data.models.bayas2.BayaRes
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {

    //conseguir listado de items
    @GET("item")
    suspend fun MostrarItems(): Response<List<itemsData>>

    @GET("berry")
    suspend fun MostrarBayas(): Response<BayaRes>

    @GET()
    suspend fun ObtenerBaya(@Url url: String): Response<ResultBayas>

}