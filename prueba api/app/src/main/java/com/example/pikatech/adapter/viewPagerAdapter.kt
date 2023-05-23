package com.example.pikatech.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class viewPagerAdapter(activity : FragmentActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 2
    }

    //Queda pendiente sustituir "CatStatFragment()" y "CatInfoFragment()" por el nombre respectivo de los fragments que se van a usar en el proyecto
    /*override fun createFragment(position: Int): Fragment {
        return if (position == 1) CatStatFragment() else CatInfoFragment()
    }*/
}