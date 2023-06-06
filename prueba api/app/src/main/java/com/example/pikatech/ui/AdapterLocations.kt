package com.example.pikatech.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pikatech.data.models.LocationsModels2.Result
import com.example.pikatech.databinding.CeldaLocationsBinding


class AdapterLocations (val myViewModel : MyViewModel, val lifeCycle: LifecycleOwner) : RecyclerView.Adapter<AdapterLocations.CeldaLocations>(), Filterable {

    private var listado_de_localizaciones = ArrayList<Result>()
    private var listado_de_localizaciones_copia = ArrayList<Result>()

    inner class CeldaLocations(val binding: CeldaLocationsBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CeldaLocations {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = CeldaLocationsBinding.inflate(layoutInflater, parent, false)
        return CeldaLocations(binding)
    }

    override fun getItemCount(): Int {
        return listado_de_localizaciones.size
    }

    fun updateList(lista: List<Result>) {
        listado_de_localizaciones.clear()
        listado_de_localizaciones.addAll(lista)
        //copia
        listado_de_localizaciones_copia.clear()
        listado_de_localizaciones_copia.addAll(lista)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: CeldaLocations, position: Int) {
        val dataLocation = listado_de_localizaciones.get(position)
        dataLocation.url?.let { myViewModel.getLocationIndividual(it).observe(lifeCycle){
            if (it != null) {
                holder.binding.tvNameLocations.text = it.name
                holder.binding.tvIdLocations.text = it.id.toString()
                holder.binding.tvRegionsLocation.text = it.region?.name.toString()

            }
        } }



    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val busqueda = constraint.toString()

                val filteredList = if (busqueda.isEmpty()) {
                    listado_de_localizaciones_copia
                } else {
                    listado_de_localizaciones_copia.filter {
                        it.name?.lowercase()?.contains(busqueda) ?: false || //minus
                                it.name?.uppercase()?.contains(busqueda) ?: false //mayus

                    }
                }
                val filterResult = FilterResults()
                filterResult.values = filteredList
                return filterResult
            }


            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                listado_de_localizaciones = results?.values as ArrayList<Result>
                notifyDataSetChanged()
            }
        }
    }
}