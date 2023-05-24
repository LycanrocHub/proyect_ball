package com.example.pikatech

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pikatech.databinding.FragmentListadoBayasBinding


class ListadoBayas : Fragment() {
    private lateinit var binding: FragmentListadoBayasBinding



//    private val personaje by activityViewModels<MyViewModel>() {
//        MyViewModel.MyViewModelFactory(requireContext())
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//
//        binding = FragmentListadoBayasBinding.inflate(inflater, container, false)
//        return binding.root
//
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        personaje.rellenar()
//
//        val layoutManager = GridLayoutManager(requireContext(), 2)
//        binding.personajesImg.layoutManager = layoutManager
//        val celdaAdapter = CeldaAdapter(personaje)
//        binding.personajesImg.adapter = celdaAdapter
//
//        personaje.listaLiveData.observe(viewLifecycleOwner) { lista ->
//            if (lista != null) {
//                celdaAdapter.llenarLista(lista)
//            }
//        }
//        personaje.liveDataposDePagina.observe(viewLifecycleOwner) { info ->
//            totalPaginas = info?.pages!!
//        }
//
//        binding.floatingActionButton.setOnClickListener {
//            val texto = binding.buscarPorNombre.text.toString()
//            if (texto.isNotEmpty())
//                personaje.buscarPorNombre(texto)
//        }
//
//        binding.avanzar.setOnClickListener {
//
//            pagina++
//            personaje.avanzarPag(pagina)
//
//
//
//        }
//        binding.retroceder.setOnClickListener {
//
//            if (pagina > totalPaginas) {
//                personaje.retrocederPag(pagina)
//                pagina--
//            }
//
//        }
//
//
//    }


}

