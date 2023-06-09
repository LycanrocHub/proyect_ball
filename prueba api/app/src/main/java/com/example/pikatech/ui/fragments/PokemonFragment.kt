package com.example.pikatech.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pikatech.R
import com.example.pikatech.data.models.pokemon.Result
import com.example.pikatech.data.models.pokemon.detallepoke.RespuestaPokemon
import com.example.pikatech.databinding.FragmentPokemonBinding
import com.example.pikatech.ui.MyViewModel
import com.example.pikatech.ui.PokemonAdapter

class PokemonFragment : Fragment() {

    private var _binding: FragmentPokemonBinding? = null
    private val binding get() = _binding!!

    private val myViewModel by activityViewModels<MyViewModel> {
        MyViewModel.MyViewModelFactory(requireContext())

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPokemonBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerview.layoutManager = GridLayoutManager(requireContext(),3, RecyclerView.VERTICAL, false)

        val pokeAdapter = PokemonAdapter(myViewModel, viewLifecycleOwner, object : PokemonAdapter.OnPokemonClickListener{

            override fun onClick(pokemon: Result) {

                myViewModel.elegirPokemon(pokemon)

                findNavController().navigate(R.id.action_PrimerFragment_to_dexFragment)

            }


        })

        binding.recyclerview.adapter = pokeAdapter

        binding.searchview.setOnQueryTextListener(object :

            android.widget.SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean {

                pokeAdapter.filter.filter(query)

                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                pokeAdapter.filter.filter(newText)

                return true

            }

        })

        myViewModel.listado_pokemon.observe(viewLifecycleOwner) {
            if (it != null){
                it.results?.forEachIndexed { index, result ->

                    result.id = index + 1

                }


                it.results?.let { it1 -> pokeAdapter.updateList(it1) }

            }

        }
        myViewModel.getPokemon()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}