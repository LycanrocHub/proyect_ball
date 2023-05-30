package com.example.pikatech.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pikatech.databinding.FragmentListadoBayasBinding
import com.example.pikatech.databinding.FragmentSecondBinding


class ListadoBayas : Fragment() {
    private var _binding: FragmentListadoBayasBinding? = null
    private val binding get() = _binding!!

    private val myViewModel by activityViewModels<MyViewModel> {
        MyViewModel.MyViewModelFactory(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListadoBayasBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recycler.layoutManager= LinearLayoutManager(context)

        val celdaAdapter = CeldaAdapter(myViewModel, viewLifecycleOwner)
        binding.recycler.adapter = celdaAdapter

        myViewModel.listado_bayas.observe(viewLifecycleOwner) { bayas ->
            bayas?.results?.let { celdaAdapter.updateList(it) }
        }

        myViewModel.getItems()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}