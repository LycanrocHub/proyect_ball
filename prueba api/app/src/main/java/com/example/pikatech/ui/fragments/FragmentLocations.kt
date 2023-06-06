package com.example.pikatech.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pikatech.databinding.FragmentLocationsBinding
import com.example.pikatech.ui.AdapterLocations
import com.example.pikatech.ui.MyViewModel

class FragmentLocations : Fragment() {

    private var _binding: FragmentLocationsBinding? = null
    private val binding get() = _binding!!

    private val myViewModel by activityViewModels<MyViewModel> {
        MyViewModel.MyViewModelFactory(requireContext())

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentLocationsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerLocal.layoutManager = LinearLayoutManager(context)

        val locationsAdapter = AdapterLocations(myViewModel, viewLifecycleOwner)
        binding.recyclerLocal.adapter = locationsAdapter

        myViewModel.listado_localizaciones.observe(viewLifecycleOwner) {
            if (it != null)
                it.results?.let { it1 -> locationsAdapter.updateList(it1) }
        }
        myViewModel.getLocations()


        binding.searchView2.setOnQueryTextListener(object :
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                locationsAdapter.filter.filter(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                locationsAdapter.filter.filter(newText)

                return true

            }

        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}