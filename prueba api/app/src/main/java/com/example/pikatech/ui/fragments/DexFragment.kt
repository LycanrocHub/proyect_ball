package com.example.pikatech.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.pikatech.R
import com.example.pikatech.databinding.FragmentDexBinding
import com.example.pikatech.ui.MyViewModel
import com.squareup.picasso.Picasso


class DexFragment() : Fragment() {

    private var _binding: FragmentDexBinding? = null
    private val binding get() = _binding!!

    private val myViewModel by activityViewModels<MyViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDexBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n", "ResourceAsColor")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        myViewModel.pokemon_seleccionado.observe(viewLifecycleOwner){

            binding.pokemonName.text = it.name

            val urlImagen = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${it.id}.png"

            Picasso.get().load(urlImagen).into(binding.pokemon);

            binding.pokemonId.text = "#${it.id}"

            it.url?.let { myViewModel.getPokemonIndividual(it).observe(viewLifecycleOwner){
            if (it != null) {

                binding.height.text = "${it.height.toString()}0 cm"

               val peso = (it.weight?.div(10))

               binding.weight.text = "${peso} Kg"

               val tipo1 = it.types?.get(0)?.type?.name

                if(tipo1 == "fire"){

                    binding.background.setBackgroundResource(R.color.fire)

                    binding.type1.setImageResource(R.drawable.fire_type)

                }else if(tipo1 == "grass"){

                    binding.background.setBackgroundResource(R.color.grass)

                    binding.type1.setImageResource(R.drawable.grass_type)

                }else if(tipo1 == "water"){

                    binding.background.setBackgroundResource(R.color.water)

                    binding.type1.setImageResource(R.drawable.water_type)

                }else if(tipo1 == "normal"){

                    binding.background.setBackgroundResource(R.color.normal)

                    binding.type1.setImageResource(R.drawable.normal_type)

                }else if(tipo1 == "fighting"){

                    binding.background.setBackgroundResource(R.color.fighting)

                    binding.type1.setImageResource(R.drawable.fighting_type)

                }else if(tipo1 == "flying"){

                    binding.background.setBackgroundResource(R.color.flying)

                    binding.type1.setImageResource(R.drawable.flying_type)

                }else if(tipo1 == "poison"){

                    binding.background.setBackgroundResource(R.color.poison)

                    binding.type1.setImageResource(R.drawable.poison_type)

                }else if(tipo1 == "ground"){

                    binding.background.setBackgroundResource(R.color.ground)

                    binding.type1.setImageResource(R.drawable.ground_type)

                }else if(tipo1 == "rock"){

                    binding.background.setBackgroundResource(R.color.rock)

                    binding.type1.setImageResource(R.drawable.rock_type)

                }else if(tipo1 == "bug"){

                    binding.background.setBackgroundResource(R.color.bug)

                    binding.type1.setImageResource(R.drawable.bug_type)

                }else if(tipo1 == "ghost"){

                    binding.background.setBackgroundResource(R.color.ghost)

                    binding.type1.setImageResource(R.drawable.ghost_type)

                }else if(tipo1 == "steel"){

                    binding.background.setBackgroundResource(R.color.steel)

                    binding.type1.setImageResource(R.drawable.steel_type)

                }else if(tipo1 == "electric"){

                    binding.background.setBackgroundResource(R.color.electric)

                    binding.type1.setImageResource(R.drawable.electric_type)

                }else if(tipo1 == "psychic"){

                    binding.background.setBackgroundResource(R.color.psychic)

                    binding.type1.setImageResource(R.drawable.psychic_type)

                }else if(tipo1 == "ice"){

                    binding.background.setBackgroundResource(R.color.ice)

                    binding.type1.setImageResource(R.drawable.ice_type)

                }else if(tipo1 == "dragon"){

                    binding.background.setBackgroundResource(R.color.dragon)

                    binding.type1.setImageResource(R.drawable.dragon_type)

                }else if(tipo1 == "dark"){

                    binding.background.setBackgroundResource(R.color.dark)

                    binding.type1.setImageResource(R.drawable.dark_type)

                }else if(tipo1 == "fairy"){

                    binding.background.setBackgroundResource(R.color.fairy)

                    binding.type1.setImageResource(R.drawable.fairy_type)

                }else {

                    binding.type1.setImageResource(R.drawable.error_type)

                }



            }
        } }

        }

    }
}

