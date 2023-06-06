package com.example.pikatech.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.pikatech.R
import com.example.pikatech.data.models.pokemon.detallemovimiento.RespuestaMovimiento
import com.example.pikatech.data.models.pokemon.detallepoke.Move
import com.example.pikatech.data.models.pokemon.detallepoke.RespuestaPokemon
import com.example.pikatech.databinding.FragmentCombatBinding
import com.example.pikatech.databinding.FragmentLoginBinding
import com.example.pikatech.ui.MyViewModel
import com.example.pikatech.ui.PokemonAdapter
import com.squareup.picasso.Picasso
import java.util.ArrayList

class CombatFragment : Fragment() {

    private var listado_pokemon_individual = ArrayList<RespuestaPokemon>()
    private var listado_movimientos = ArrayList<RespuestaMovimiento>()

    private val myViewModel by activityViewModels<MyViewModel> {
        MyViewModel.MyViewModelFactory(requireContext())

    }

    private var _binding: FragmentCombatBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCombatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val randomNumber1 = 1 .. 1010
        val randomNumber2 = 1 .. 1010
        val randomPokemonId1 = randomNumber1.random()
        val randomPokemonId2 = randomNumber2.random()

        val pokemonInfo1 = listado_pokemon_individual[randomPokemonId1]
        val pokemonInfo2 = listado_pokemon_individual[randomPokemonId2]
        val movimientosPokemon = listado_movimientos[1]

        val urlImagenPokemon1 = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${randomPokemonId1}.png"
        Picasso.get().load(urlImagenPokemon1).into(binding.pokemon1)

        binding.button5.text = pokemonInfo1.moves?.get(1)?.move?.name
        binding.button6.text = pokemonInfo1.moves?.get(2)?.move?.name
        binding.button7.text = pokemonInfo1.moves?.get(3)?.move?.name
        binding.button8.text = pokemonInfo1.moves?.get(4)?.move?.name

        val movimiento1 = movimientosPokemon.versionGroupDetails?.get(1).mo

        val urlImagenPokemon2 = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${randomPokemonId2}.png"
        Picasso.get().load(urlImagenPokemon2).into(binding.pokemon2)

        val hpPokemon1 = 100
        val hpPokemon2 = 100

        binding.progressBar4.progress = 100
        binding.progressBar3.progress = 100

        if (hpPokemon1 >= 0 && hpPokemon2 >=0) {

            fun atacar() {

            }

        } else if (hpPokemon1 == 0 || hpPokemon2 ==0) {



        }

    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        val randomNumber1 = 1 .. 1010
//        val randomNumber2 = 1 .. 1010
//        val randomPokemonId1 = randomNumber1.random()
//        val randomPokemonId2 = randomNumber2.random()
//
//        val pokemonInfo1 = listado_pokemon_individual.get(randomPokemonId1)
//        val pokemonInfo2 = listado_pokemon_individual.get(randomPokemonId2)
//
//        val urlImagenPokemon1 = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${randomPokemonId1}.png"
//        Picasso.get().load(urlImagenPokemon1).into(binding.pokemon1)
//        binding.button5.text = pokemonInfo1.abilities?.get(0).toString()
//        binding.button6.text = pokemonInfo1.abilities?.get(1).toString()
//        binding.button7.text = pokemonInfo1.abilities?.get(2).toString()
//        binding.button8.text = pokemonInfo1.abilities?.get(3).toString()
//
//        val urlImagenPokemon2 = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${randomPokemonId2}.png"
//
//
//        Picasso.get().load(urlImagenPokemon2).into(binding.pokemon2)
//
//    }
}