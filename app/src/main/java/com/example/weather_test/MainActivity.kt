package com.example.weather_test

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.weather_test.R

class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_container)
       val navHostFragment =
       supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        appBarConfiguration.fallbackOnNavigateUpListener

        navController.addOnDestinationChangedListener { _, destination: NavDestination, _ ->
            val toolBar = supportActionBar ?: return@addOnDestinationChangedListener
            toolBar.setTitle(R.string.app_name)
            when (destination.id) {
                R.id.weatherListFragment -> {
                    toolBar.setDisplayShowTitleEnabled(true)
                    toolBar.setTitle(R.string.app_name)
                    toolBar.setDisplayHomeAsUpEnabled(false)
                }
                else -> {
                    toolBar.setDisplayShowTitleEnabled(false)
                    toolBar.setDisplayHomeAsUpEnabled(true)


                }
            }
        }
        }
        override fun onSupportNavigateUp(): Boolean {
            val navController = this.findNavController(R.id.nav_host_fragment)
            return navController.navigateUp()

    }
}