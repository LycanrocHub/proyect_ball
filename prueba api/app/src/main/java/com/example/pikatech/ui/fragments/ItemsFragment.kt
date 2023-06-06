package com.example.pikatech.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pikatech.databinding.FragmentItemsBinding


class ItemsFragment : Fragment() {

    private var _binding: FragmentItemsBinding? = null
    private val binding get() = _binding!!

    private val myViewModel by activityViewModels<MyViewModel> {
        MyViewModel.MyViewModelFactory(requireContext())

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentItemsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recycler.layoutManager = LinearLayoutManager(context)

        val itemsAdapter = AdapterItems(myViewModel, viewLifecycleOwner)
        binding.recycler.adapter = itemsAdapter

        myViewModel.listado_items.observe(viewLifecycleOwner) {
            if (it != null)
                it.results?.let { it1 -> itemsAdapter.updateList(it1) }
        }
        myViewModel.getItems()


        binding.search.setOnQueryTextListener(object :
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                itemsAdapter.filter.filter(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                itemsAdapter.filter.filter(newText)

                return true

            }

        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}