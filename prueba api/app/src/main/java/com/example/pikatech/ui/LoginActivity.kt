package com.example.pikatech.ui

import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.pikatech.R
import com.example.pikatech.databinding.ActivityLoginBinding
import com.example.pikatech.databinding.ActivityMainBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, true)
        super.onCreate(savedInstanceState)


        binding = ActivityLoginBinding.inflate(layoutInflater)

        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.toolbar.setTitleTextColor(Color.WHITE)


        val navController = findNavController(R.id.containerview)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)



    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.containerview)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}