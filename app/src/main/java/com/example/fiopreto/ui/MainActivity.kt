package com.example.fiopreto.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.fiopreto.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val navController: NavController by lazy { findNavController(R.id.nav_host_fragment_container) }
    private lateinit var navButton : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navButton = findViewById(R.id.navigation)

        navButton.setOnNavigationItemSelectedListener {
            var selectedFragment : Fragment = FeedFragment()
            when(it.itemId){
                R.id.navigation_home -> selectedFragment.allowEnterTransitionOverlap
                R.id.navigation_tips -> selectedFragment.allowEnterTransitionOverlap
                R.id.navigation_feed -> selectedFragment.allowEnterTransitionOverlap
                R.id.navigation_salon -> selectedFragment.allowEnterTransitionOverlap
                R.id.navigation_profile -> selectedFragment.allowEnterTransitionOverlap
                else -> {
                    selectedFragment = FeedFragment()
                    selectedFragment.allowEnterTransitionOverlap
                }
            }
        }
        true

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }
}


