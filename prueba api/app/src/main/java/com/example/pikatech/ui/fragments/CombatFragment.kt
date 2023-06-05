package com.example.pikatech.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pikatech.R
import com.example.pikatech.databinding.FragmentCombatBinding
import com.example.pikatech.databinding.FragmentLoginBinding

class CombatFragment : Fragment() {

    private var _binding: FragmentCombatBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCombatBinding.inflate(inflater, container, false)
        return binding.root
    }
}