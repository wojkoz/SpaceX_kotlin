package com.example.spacex_kotlin

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.spacex_kotlin.historicalEventsFragment.HistoricalEventsFragment
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , NavigationView.OnNavigationItemSelectedListener{

    lateinit var toolbar: Toolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var navView: NavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //drawer
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.nav_view)

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, 0, 0
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener(this)



    }


    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {

        when (menuItem.itemId) {
            R.id.historicalEventsFragment -> {
                Toast.makeText(this, "historicalEventsFragment", Toast.LENGTH_SHORT).show()
                Navigation.findNavController(this, R.id.nav_host_fragment).navigate(R.id.historicalEventsFragment)
            }
            R.id.missionsFragment -> {
                Toast.makeText(this, "missionsFragment", Toast.LENGTH_SHORT).show()
            }
            R.id.rocketsFragment -> {
                Toast.makeText(this, "rocketsFragment", Toast.LENGTH_SHORT).show()
            }
            R.id.launchesFragment -> {
                Toast.makeText(this, "launchesFragment", Toast.LENGTH_SHORT).show()
            }
            R.id.roadsterFragment -> {
                Toast.makeText(this, "roadsterFragment", Toast.LENGTH_SHORT).show()
            }
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

}
