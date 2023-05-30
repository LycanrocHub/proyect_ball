package com.example.pikatech.ui

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pikatech.data.Repositorio
import com.example.pikatech.data.models.ItemsModels.itemsData
import com.example.pikatech.data.models.bayas.ResultBayas
import com.example.pikatech.data.models.bayas2.BayaRes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyViewModel(val context: Context) : ViewModel() {
    private val repositorio = Repositorio(context)

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

    fun getItems() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = repositorio.getBayas()
            if (response.isSuccessful) {
                val respuesta_baya = response.body()
                listado_bayas.postValue(respuesta_baya)
            }
        }
    }

    class MyViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return modelClass.getConstructor(Context::class.java).newInstance(context)
        }
    }
}