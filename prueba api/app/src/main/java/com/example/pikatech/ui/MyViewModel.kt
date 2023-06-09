package com.example.pikatech.ui

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pikatech.data.Repositorio
import com.example.pikatech.data.models.ItemsModels.itemsData
import com.example.pikatech.data.models.pokemon.ListadoPokemon
import com.example.pikatech.data.models.pokemon.detallepoke.RespuestaPokemon
import com.example.pikatech.data.models.ItemsModels2.items
import com.example.pikatech.data.models.LocationsModels.locationData
import com.example.pikatech.data.models.LocationsModels2.Locations
import com.example.pikatech.data.models.bayas.ResultBayas
import com.example.pikatech.data.models.bayas2.BayaRes
import com.example.pikatech.data.models.pokemon.Result
import com.example.pikatech.data.models.pokemon.detallemovimiento.RespuestaMovimiento
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyViewModel(val context: Context) : ViewModel() {
    private val repositorio = Repositorio(context)


    val listado_items = MutableLiveData<items?>()
    val listado_pokemon = MutableLiveData<ListadoPokemon?>()
    val listado_localizaciones = MutableLiveData<Locations?>()
    val pokemon_seleccionado = MutableLiveData<Result>()

    fun getItemsIndividual(url: String): MutableLiveData<itemsData?> {
        val itemIndividual = MutableLiveData<itemsData?>()
        CoroutineScope(Dispatchers.IO).launch {
            val response = repositorio.getItemIndividual(url)
            if (response.isSuccessful) {
                val respuesta_items_ind = response.body()
                itemIndividual.postValue(respuesta_items_ind)
            }
        }
        return itemIndividual
    }

    val listado_bayas = MutableLiveData<BayaRes?>()


    fun getBayaIndividual(url: String): MutableLiveData<ResultBayas?> {
        val itemIndividual = MutableLiveData<ResultBayas?>()
        CoroutineScope(Dispatchers.IO).launch {
            val response = repositorio.getBayaIndividual(url)
            if (response.isSuccessful) {
                val respuesta_baya_ind = response.body()
                itemIndividual.postValue(respuesta_baya_ind)
            }
        }
        return itemIndividual
    }

    fun getLocations() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = repositorio.getLocations()
            if (response.isSuccessful) {
                val respuesta_localizaciones = response.body()
                listado_localizaciones.postValue(respuesta_localizaciones)
            }
        }
    }

    fun getBayas() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = repositorio.getBayas()
            if (response.isSuccessful) {
                val respuesta_baya = response.body()
                listado_bayas.postValue(respuesta_baya)
            }
        }
    }
    fun getLocationIndividual(url: String): MutableLiveData<locationData?> {
        val LocationIndividual = MutableLiveData<locationData?>()
        CoroutineScope(Dispatchers.IO).launch {
            val response = repositorio.getLocationIndividual(url)
            if (response.isSuccessful) {
                val respuesta_local_ind = response.body()
                LocationIndividual.postValue(respuesta_local_ind)
            }
        }
        return LocationIndividual
    }


    fun getItems() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = repositorio.getItems()
            if (response.isSuccessful) {
                val respuesta_items = response.body()
                listado_items.postValue(respuesta_items)
            }
        }
    }

    fun getPokemon(){
        CoroutineScope(Dispatchers.IO).launch {
            val response = repositorio.getPokemon(0, 1010)
            if(response.isSuccessful){
                val respuesta_pokemon = response.body()
                listado_pokemon.postValue(respuesta_pokemon)
            }
        }
    }

    fun getPokemonIndividual(url: String): MutableLiveData<RespuestaPokemon?>{
        val pokemonIndividual = MutableLiveData<RespuestaPokemon?>()
        CoroutineScope(Dispatchers.IO).launch {
            val response = repositorio.getPokemonIndividual(url)
            if(response.isSuccessful){
                val respuesta_pokemon_ind = response.body()
                pokemonIndividual.postValue(respuesta_pokemon_ind)
            }
        }
        return pokemonIndividual
    }

    fun getDatosMovimiento(url: String) : MutableLiveData<RespuestaMovimiento?> {
        val datosMovimiento = MutableLiveData<RespuestaMovimiento?>()
        CoroutineScope(Dispatchers.IO).launch {
            val response = repositorio.getDatosMovimiento(url)
            if(response.isSuccessful){
                val respuesta_movimiento_ind = response.body()
                datosMovimiento.postValue(respuesta_movimiento_ind)
            }
        }
        return datosMovimiento
    }

    fun elegirPokemon(pokemon: Result) {

        pokemon_seleccionado.value = pokemon

    }

    class MyViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return modelClass.getConstructor(Context::class.java).newInstance(context)
        }
    }
}