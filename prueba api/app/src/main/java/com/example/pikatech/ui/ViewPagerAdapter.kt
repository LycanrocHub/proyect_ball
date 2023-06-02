package com.example.pikatech.ui

import android.app.Activity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.pikatech.FragmentLocations
import com.example.pikatech.MainActivity


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