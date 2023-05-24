package com.example.pikatech.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.example.pikatech.data.models.ItemsModels.itemsData
import com.example.pikatech.databinding.VistaCeldaBinding
import com.example.pikatech.databinding.VistaCeldaSecondBinding

class AdapterItems(
    val listener: AdapterView.OnItemClickListener
) : RecyclerView.Adapter<AdapterItems.CeldaItems>() {

    private var listado_de_items = ArrayList<itemsData>()
    private var listado_de_items_copia = ArrayList<itemsData>()

    interface OnItemClickListener {
        fun onItemClick(dataItem: itemsData)
    }

    inner class CeldaItems(val binding: VistaCeldaSecondBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CeldaItems {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = VistaCeldaSecondBinding.inflate(layoutInflater, parent, false)
        return CeldaItems(binding)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: CeldaItems, position: Int) {
      val dataItem : itemsData = listado_de_items.get(position)
        holder.binding.costItem2.text = dataItem.cost.toString()
        holder.binding.idItem2.text = dataItem.id.toString()
    }

}