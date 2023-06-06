package com.example.pikatech.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pikatech.data.models.ItemsModels2.ResultX
import com.example.pikatech.databinding.VistaCeldaItemsBinding


class AdapterItems(val myViewModel : MyViewModel, val lifeCycle: LifecycleOwner) : RecyclerView.Adapter<AdapterItems.CeldaItems>(), Filterable {

    private var listado_de_items = ArrayList<ResultX>()
    private var listado_de_items_copia = ArrayList<ResultX>()


    inner class CeldaItems(val binding: VistaCeldaItemsBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CeldaItems {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = VistaCeldaItemsBinding.inflate(layoutInflater, parent, false)
        return CeldaItems(binding)
    }

    override fun getItemCount(): Int {
        return listado_de_items.size
    }

    fun updateList(lista: List<ResultX>) {
        listado_de_items.clear()
        listado_de_items.addAll(lista)
        //copia
        listado_de_items_copia.clear()
        listado_de_items_copia.addAll(lista)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: CeldaItems, position: Int) {
        val dataItem = listado_de_items.get(position)
        holder.binding.nameItem.text = dataItem.name
        dataItem.url?.let { myViewModel.getItemsIndividual(it).observe(lifeCycle){
            if (it != null) {
                holder.binding.idItem2.text = it.id.toString()
                holder.binding.costItem2.text = it.cost.toString() + " Pokedólares "


                with(holder.binding) {
                    Glide.with(
                        holder
                            .itemView.context
                    )
                        .load(it.sprites?.default)
                        .into(holder.binding.imageItem2)
                }
            }
        } }

    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val busqueda = constraint.toString()

                //lógica de búsqueda
                val filteredList = if (busqueda.isEmpty()) {
                    listado_de_items_copia
                } else {
                    listado_de_items_copia.filter {
                        it.name?.lowercase()?.contains(busqueda) ?: false || //minus
                                it.name?.uppercase()?.contains(busqueda) ?: false //mayus

                    }
                }
                val filterResult = FilterResults()
                filterResult.values = filteredList
                return filterResult
            }


            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                listado_de_items = results?.values as ArrayList<ResultX>
                notifyDataSetChanged()
            }
        }
    }
}