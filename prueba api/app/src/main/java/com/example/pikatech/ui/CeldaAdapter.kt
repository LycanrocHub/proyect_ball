package com.example.pikatech.ui

import com.example.pikatech.data.models.bayas.ResultBayas
import com.example.pikatech.databinding.VistaCeldaBinding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
//class CeldaAdapter( val viewModel: MyViewModel ) : RecyclerView.Adapter<CeldaAdapter.VistaCelda>() {
//
//    private var personajeLista = ArrayList<ResultBayas?>()
//    inner class VistaCelda(val binding: VistaCeldaBinding) : RecyclerView.ViewHolder(binding.root)
//
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VistaCelda {
//        val inflater = LayoutInflater.from(parent.context)
//        val binding = VistaCeldaBinding.inflate(inflater, parent, false)
//        val celda = VistaCelda(binding)
//        return celda
//    }
//
//    override fun getItemCount(): Int {
//        return personajeLista.size
//    }
//
//    override fun onBindViewHolder(holder: VistaCelda, position: Int) {
//        var personaje = personajeLista[position]
//
//
//        with (holder.binding) {
//
//
//
//        }
//    }
//
//
//    fun llenarLista(lista: List<ResultBayas?>) {
//        personajeLista.clear()
//        personajeLista.addAll(lista)
//        notifyDataSetChanged()
//    }
//
//
//}