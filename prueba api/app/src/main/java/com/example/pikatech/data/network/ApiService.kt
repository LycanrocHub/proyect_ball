package com.example.pikatech.data.network

import com.example.pikatech.data.models.ItemsModels.itemsData
<<<<<<< HEAD
import com.example.pikatech.data.models.ItemsModels2.items
import com.example.pikatech.data.models.LocationsModels.locationData
import com.example.pikatech.data.models.LocationsModels2.Locations
=======
import com.example.pikatech.data.models.bayas.ResultBayas
import com.example.pikatech.data.models.bayas2.BayaRes
>>>>>>> 05dc43fac693782fc2affcf504f25dbd987070f2
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {

    //conseguir listado de items
    @GET("item")
    suspend fun MostrarItems(): Response<items>

<<<<<<< HEAD
    @GET()
    suspend fun ObtenerItem(@Url url: String): Response<itemsData>


    //conseguir listado de localizaciones
    @GET("location")
    suspend fun MostrarLocalizaciones(): Response<Locations>

    @GET()
    suspend fun ObtenerLocalizaciones(@Url url: String): Response<locationData>
=======
    @GET("berry")
    suspend fun MostrarBayas(): Response<BayaRes>

    @GET()
    suspend fun ObtenerBaya(@Url url: String): Response<ResultBayas>
>>>>>>> 05dc43fac693782fc2affcf504f25dbd987070f2

}