package com.example.pikatech.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pikatech.data.models.pokemon.Result
import com.example.pikatech.databinding.VistaCeldaPokemonBinding

class PokemonAdapter(val myViewModel : MyViewModel, val lifeCycle: LifecycleOwner) : RecyclerView.Adapter<PokemonAdapter.CeldaPokemon>() {

    private var listado_de_pokemon = ArrayList<Result>()
    private var listado_de_pokemon_copia = ArrayList<Result>()


    inner class CeldaPokemon(val binding: VistaCeldaPokemonBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CeldaPokemon {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = VistaCeldaPokemonBinding.inflate(layoutInflater, parent, false)
        return CeldaPokemon(binding)
    }

    override fun onBindViewHolder(holder: PokemonAdapter.CeldaPokemon, position: Int) {
        val dataItem = listado_de_pokemon.get(position)
        holder.binding.pokemonNombre.text = dataItem.name
        val urlImagen = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${position + 1}.png"
        with(holder.binding) {
            Glide.with(
                holder
                    .itemView.context
            )
                .load(urlImagen)
                .into(holder.binding.pokemonFoto)
        }
//        dataItem.url?.let { myViewModel.getPokemonIndividual(it).observe(lifeCycle){
//            if (it != null) {
//
//                with(holder.binding) {
//                    Glide.with(
//                        holder
//                            .itemView.context
//                    )
//                        .load(it.sprites?.frontDefault)
//                        .into(holder.binding.pokemonFoto)
//                }
//            }
//        } }
    }

    override fun getItemCount(): Int {
        return listado_de_pokemon.size
    }

    fun updateList(lista: List<Result>) {
        listado_de_pokemon.clear()
        listado_de_pokemon.addAll(lista)
        //copia
        listado_de_pokemon_copia.clear()
        listado_de_pokemon_copia.addAll(lista)
        notifyDataSetChanged()
    }


}