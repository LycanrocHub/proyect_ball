package com.example.pikatech.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pikatech.data.models.pokemon.Result
import com.example.pikatech.data.models.pokemon.detallepoke.RespuestaPokemon
import com.example.pikatech.databinding.VistaCeldaPokemonBinding
import com.squareup.picasso.Picasso

class PokemonAdapter(val myViewModel : MyViewModel, val lifeCycle: LifecycleOwner, val listener: OnPokemonClickListener) : RecyclerView.Adapter<PokemonAdapter.CeldaPokemon>(),
    Filterable {

    interface OnPokemonClickListener {

        fun onClick(pokemon: Result)

    }

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

        val urlImagen = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${dataItem.id}.png"

        Picasso.get().load(urlImagen).into(holder.binding.pokemonFoto);

        holder.itemView.setOnClickListener {

            listener.onClick(dataItem)

        }

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

    override fun getFilter(): Filter {
        return object : Filter(){
            override fun performFiltering(constraint: CharSequence?): FilterResults {

                val busqueda = constraint.toString()

                if(busqueda .isEmpty()){

                    listado_de_pokemon = listado_de_pokemon_copia

                }else{

                    listado_de_pokemon = listado_de_pokemon_copia.filter {

                        it?.name?.lowercase()?.contains(busqueda.lowercase()) ?: false

                    } as ArrayList<Result>

                }

                val filterResult = FilterResults()

                filterResult.values = listado_de_pokemon

                return filterResult

            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {

                listado_de_pokemon = results?.values as ArrayList<Result>

                notifyDataSetChanged()

            }
        }
    }


}