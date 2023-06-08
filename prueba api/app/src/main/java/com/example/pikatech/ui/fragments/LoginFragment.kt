package com.example.pikatech.ui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import android.widget.Toast
import androidx.core.view.isInvisible
import com.example.pikatech.MainActivity
import com.example.pikatech.R
import com.example.pikatech.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.imageView10.visibility = View.INVISIBLE

        // Animación vertical para el texto de "BIENVENIDO!"
        val animacion1 = TranslateAnimation(0.0f, 0.0f, -1600.0f, 0.0f)
        animacion1.duration = 1100

        // Configuración para que se realice la segunda animación una vez finalizada la primera
        animacion1.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {
                //Para cuando se quiera hacer algo al iniciar una animación
            }

            override fun onAnimationEnd(animation: Animation) {
                // Primera animación finalizada, configuración e inicialización de la segunda animación
                val animacion2 = TranslateAnimation(-1500f, 0.0f, 0.0f, 0.0f)
                animacion2.duration = 800
                binding.imageView10.visibility = View.VISIBLE
                binding.imageView10.startAnimation(animacion2)
            }

            override fun onAnimationRepeat(animation: Animation) {
                //Para cuando se quiera repetir la animación
            }
        })

        binding.imageView9.startAnimation(animacion1)

        binding.imageView11.setOnClickListener {
            val userName = binding.textInputEditTextUserName.text.toString()
            val userPassword = binding.textInputEditTextUserPassword.text.toString()
            if (userName.isNotEmpty() && userPassword.isNotEmpty()) {
                startActivity(Intent(requireContext(), MainActivity::class.java))
                requireActivity().finish()
            } else {
                Toast.makeText(requireContext(), "Faltan campos que rellenar. Vuelva a intentarlo", Toast.LENGTH_SHORT).show()
            }
        }

    }
}