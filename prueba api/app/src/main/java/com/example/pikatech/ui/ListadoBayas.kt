package com.example.pikatech.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pikatech.databinding.FragmentListadoBayasBinding


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

        myViewModel.getBayas()
        binding.searchView3.setOnQueryTextListener(object :
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                celdaAdapter.filter.filter(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                celdaAdapter.filter.filter(newText)

                return true

            }

        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
