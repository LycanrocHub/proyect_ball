package com.example.pikatech.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pikatech.R
import com.example.pikatech.databinding.FragmentCombatBinding
import com.squareup.picasso.Picasso
import kotlin.random.Random
import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import android.widget.Toast

class CombatFragment : Fragment() {

    private var _binding: FragmentCombatBinding? = null
    private val binding get() = _binding!!

    private var saludPokemon1 = 100
    private var saludPokemon2 = 100
    private var turnoJugador = true
    private var ataqueJugador = false
    private var defensaJugador = false

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

        val urlImagenPokemon1 = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/${randomPokemonId1}.png"
        Picasso.get().load(urlImagenPokemon1).error(R.drawable.error).into(binding.pokemon1)

        val urlImagenPokemon2 = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${randomPokemonId2}.png"
        Picasso.get().load(urlImagenPokemon2).into(binding.pokemon2)

        val animacionJugador = TranslateAnimation(-800.0f, 0.0f, 0.0f, 0.0f)
        animacionJugador.duration = 1000
        binding.pokemon1.startAnimation(animacionJugador)

        val animacionIA = TranslateAnimation(1000.0f, 0.0f, 0.0f, 0.0f)
        animacionIA.duration = 1600
        binding.pokemon2.startAnimation(animacionIA)

        binding.progressBar4.progress = saludPokemon1
        binding.progressBar3.progress = saludPokemon2

        binding.button5.setOnClickListener {
            if (turnoJugador && saludPokemon2 > 0) {
                atacarJugador()
                ejecutarTurnoIA()
            }
        }

        binding.button6.setOnClickListener {
            if (turnoJugador && saludPokemon1 > 0) {
                defenderJugador()
                turnoJugador = false
                defensaJugador = true
                ejecutarTurnoIA()
            }
        }
    }

    private fun ejecutarTurnoIA() {
        if (!turnoJugador) {
            val posibilidadAtaqueDefensa = 1..2
            val posibilidad = posibilidadAtaqueDefensa.random()
            if (posibilidad == 1) {
                atacarIA()
                turnoJugador = true
            } else if (posibilidad == 2) {
                defenderIA()
                turnoJugador = true
            }
        }
    }

    private fun atacarJugador() {
        if (saludPokemon2 > 0) {
            animacionesAtaqueJugador()
            val dañoRecibido = 20
            saludPokemon2 -= dañoRecibido
            binding.textView3.text = "$saludPokemon2 HP"
            binding.progressBar3.progress = saludPokemon2
            Toast.makeText(requireContext(), "¡El rival no ha podido esquivar tu ataque!", Toast.LENGTH_SHORT).show()
            turnoJugador = false
            ataqueJugador = true
            if (saludPokemon2 == 0) {
                val animacionDesplazamiento = TranslateAnimation(0.0f, 1000.0f, 0.0f, 0.0f)
                animacionDesplazamiento.duration = 500
                binding.pokemon2.startAnimation(animacionDesplazamiento)
                mostrarDialogoFinCombate("¡Has ganado!")
            }
        }
    }

    private fun defenderJugador() {
        if (Random.nextBoolean()) {
            animacionesAtaqueIA()
            val dañoRecibido = 20
            saludPokemon1 -= dañoRecibido
            binding.textView4.text = "$saludPokemon1 HP"
            binding.progressBar4.progress = saludPokemon1
            Toast.makeText(requireContext(), "¡No has podido esquivar el ataque del rival!", Toast.LENGTH_SHORT).show()
            if (saludPokemon1 == 0) {
                mostrarDialogoFinCombate("Has perdido :(")
            }
        } else {
            animacionAtaqueBloqueadoIA()
            Toast.makeText(requireContext(), "¡Has esquivado el ataque del rival!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun atacarIA() {
        if (saludPokemon1 > 0) {
            if (saludPokemon1 == 0) {
                val animacionDesplazamiento = TranslateAnimation(0.0f, -1000.0f, 0.0f, 0.0f)
                animacionDesplazamiento.duration = 500
                binding.pokemon1.startAnimation(animacionDesplazamiento)

                mostrarDialogoFinCombate("¡Has perdido! :(")
            }
        }
    }

    private fun defenderIA() {
        if (Random.nextBoolean()) {
            animacionesAtaqueJugador()
            val dañoRecibido = 20
            saludPokemon2 -= dañoRecibido
            binding.textView3.text = "$saludPokemon2 HP"
            binding.progressBar3.progress = saludPokemon2
            Toast.makeText(requireContext(), "¡El rival no ha podido esquivar tu ataque!", Toast.LENGTH_SHORT).show()
            ataqueJugador = false
            if (saludPokemon2 == 0) {
                mostrarDialogoFinCombate("¡Has ganado!")
            }
        } else {
            animacionAtaqueBloqueadoJugador()
            Toast.makeText(requireContext(), "¡El rival esquivó tu ataque!", Toast.LENGTH_SHORT).show()
            ataqueJugador = false
        }
    }

    private fun mostrarDialogoFinCombate(mensaje: String) {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Fin del combate")
        builder.setMessage(mensaje)
        builder.setPositiveButton("Aceptar", DialogInterface.OnClickListener { dialog, _ ->
            dialog.dismiss()
        })
        builder.setCancelable(false)
        builder.show()
    }

    private fun animacionesAtaqueJugador() {
        val animacionAtaqueJugador = TranslateAnimation(0.0f, 350.0f, 0.0f, -100.0f)
        animacionAtaqueJugador.duration = 400
        binding.pokemon1.startAnimation(animacionAtaqueJugador)
        Handler().postDelayed({
            val animacionDañoIA = TranslateAnimation(0.0f, -50.0f, 0.0f, 0.0f)
            animacionDañoIA.duration = 200
            animacionDañoIA.repeatMode = Animation.REVERSE
            animacionDañoIA.repeatCount = 3
            binding.pokemon2.startAnimation(animacionDañoIA)
        }, 400)
    }

    private fun animacionAtaqueBloqueadoJugador() {
        val animacionAtaqueJugador = TranslateAnimation(0.0f, 350.0f, 0.0f, -100.0f)
        animacionAtaqueJugador.duration = 400
        binding.pokemon1.startAnimation(animacionAtaqueJugador)
    }

    private fun animacionesAtaqueIA() {
        val animacionAtaqueIA = TranslateAnimation(0.0f, -350.0f, 0.0f, 100.0f)
        animacionAtaqueIA.duration = 400
        binding.pokemon2.startAnimation(animacionAtaqueIA)
        Handler().postDelayed({
            val animacion = TranslateAnimation(0.0f, -50.0f, 0.0f, 0.0f)
            animacion.duration = 200
            animacion.repeatMode = Animation.REVERSE
            animacion.repeatCount = 3
            binding.pokemon1.startAnimation(animacion)
        }, 400)
    }

    private fun  animacionAtaqueBloqueadoIA() {
        val animacionAtaqueIA = TranslateAnimation(0.0f, -350.0f, 0.0f, 100.0f)
        animacionAtaqueIA.duration = 400
        binding.pokemon2.startAnimation(animacionAtaqueIA)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}