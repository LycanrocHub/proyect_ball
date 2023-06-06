package com.example.pikatech.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.ui.AppBarConfiguration
import com.example.pikatech.databinding.FragmentPrimerBinding
import com.example.pikatech.ui.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator


class PrimerFragment : Fragment() {

    private var _binding: FragmentPrimerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPrimerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val adapter = ViewPagerAdapter(this@PrimerFragment)
        binding.viewpager.adapter = adapter

        TabLayoutMediator(binding.tablayout, binding.viewpager) { tab, position ->
            tab.text = when(position){

                0 -> "Pokemon"

                1 -> "Items"

                3-> "Bayas"

                else -> "Localizaciones"
            }
        }.attach()
    }
}