package com.example.pikatech.ui

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.pikatech.ui.fragments.FragmentLocations
import com.example.pikatech.ui.fragments.PokemonFragment
import com.example.pikatech.ui.fragments.PrimerFragment


class ViewPagerAdapter(activity: PrimerFragment) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){

            0-> PokemonFragment()

            1 -> ItemsFragment()

            2 -> FragmentLocations()

            else -> ListadoBayas()
        }
    }


}