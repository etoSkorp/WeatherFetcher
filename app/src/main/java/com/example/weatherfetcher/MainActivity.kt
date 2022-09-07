package com.example.weatherfetcher

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val bnvMenu: BottomNavigationView by lazy { findViewById(R.id.bnvMenu) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bnvMenu.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.itemMain -> {
                    changeFragment(MainScreenFragment())
                }
                R.id.itemWindDeg -> {
                    changeFragment(WindSpeedInfoFragment())
                }
                else -> {}
            }
            true
        }
        bnvMenu.selectedItemId = R.id.itemMain
    }

    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
    }
}