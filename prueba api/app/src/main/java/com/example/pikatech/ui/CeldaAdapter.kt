package com.example.pikatech.ui

import com.example.pikatech.data.models.bayas.ResultBayas
import com.example.pikatech.databinding.VistaCeldaBinding

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.pikatech.data.models.ItemsModels.itemsData
import com.example.pikatech.data.models.bayas2.ResultX


class CeldaAdapter(private val viewModel: MyViewModel, private val lifeCycle: LifecycleOwner) :
    RecyclerView.Adapter<CeldaAdapter.VistaCelda>(), Filterable {

    private var listado_de_Bayas = ArrayList<ResultX>()
    private val listado_de_bayas_copia = ArrayList<ResultX>()

    inner class VistaCelda(val binding: VistaCeldaBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VistaCelda {
        val inflater = LayoutInflater.from(parent.context)
        val binding = VistaCeldaBinding.inflate(inflater, parent, false)
        return VistaCelda(binding)
    }

    override fun getItemCount(): Int {
        return listado_de_Bayas.size
    }

    fun updateList(lista: List<ResultX>) {
        listado_de_Bayas.clear()
        listado_de_Bayas.addAll(lista)
        // Copia
        listado_de_bayas_copia.clear()
        listado_de_bayas_copia.addAll(lista)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: VistaCelda, position: Int) {
        val dataItem = listado_de_Bayas[position]

        dataItem.url?.let { url ->
            viewModel.getBayaIndividual(url).observe(lifeCycle) { item ->
                if (item != null) {
                    holder.binding.nombreBaya.text = item.id.toString()
                    holder.binding.tipoBaya.text = item.name.toString()
                }
            }
        }
    }


    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val busqueda = constraint.toString()


                val filteredList = if (busqueda.isEmpty()) {
                    listado_de_bayas_copia
                } else {
                    listado_de_bayas_copia.filter {
                        it.name?.lowercase()?.contains(busqueda) ?: false || //minus
                                it.name?.uppercase()?.contains(busqueda) ?: false //mayus

                    }
                }
                val filterResult = FilterResults()
                filterResult.values = filteredList
                return filterResult
            }


            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                listado_de_Bayas = results?.values as ArrayList<ResultX>
                notifyDataSetChanged()
            }
        }
    }
}