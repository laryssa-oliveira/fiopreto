package com.example.fiopreto.ui

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.fiopreto.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.fragment_find_salon.*

class HomeActivity : AppCompatActivity(),
    BottomNavigationView.OnNavigationItemSelectedListener {


    private lateinit var navButton: BottomNavigationView
    //private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        navButton = findViewById(R.id.navigation)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setActionBar(toolbar)
        //setupToolbar()
        startFragment()

    }
    /*
    private fun setupToolbar() {
        //(activity as AppCompatActivity).run {
            setSupportActionBar(toolbar)
            supportActionBar?.setDisplayShowTitleEnabled(false)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        //}
    }*/

    private fun startFragment() {
        val homeFragment = HomeFragment()
        supportFragmentManager.beginTransaction()
            .add(R.id.nav_host_home, homeFragment)
            .commit()
    }

    override fun onResume() {
        super.onResume()
        navButton.setOnNavigationItemSelectedListener(this)
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.navigation_home -> {
                val homeFragment = HomeFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_home, homeFragment)
                    .commit()
            }
            R.id.navigation_tips -> {
                val tipsFragment = TipsFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_home, tipsFragment)
                    .commit()
            }
            R.id.navigation_feed -> {
                val feedFragment = FeedFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_home, feedFragment)
                    .commit()
            }
            R.id.navigation_salon -> {
                val findSalonFragment = SalonFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_home, findSalonFragment)
                    .commit()
            }
            R.id.navigation_profile -> {
                val profileFragment = ProfileFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_home, profileFragment)
                    .commit()
            }
        }
        return true
    }

}

