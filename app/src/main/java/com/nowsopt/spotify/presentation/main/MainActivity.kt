package com.nowsopt.spotify.presentation.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.nowsopt.spotify.R
import com.nowsopt.spotify.databinding.ActivityMainBinding
import com.nowsopt.spotify.util.base.BindingActivity

class MainActivity : BindingActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {
    enum class BottomNavigationType(val menuId: Int) {
        HOME(R.id.menu_home),
        SEARCH(R.id.menu_search),
        LIBRARY(R.id.menu_library),
        PREMIUM(R.id.menu_spotify);

        companion object {
            fun getScreenEnum(id: Int) = BottomNavigationType.entries.first { it.menuId == id }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initFragmentView()
        initBottomNavigation()
    }

    private fun initFragmentView() {
        val currentFragment = supportFragmentManager.findFragmentById(binding.fcvHome.id)
        if (currentFragment == null) {
            supportFragmentManager.beginTransaction()
                .add(binding.fcvHome.id, HomeFragment())
                .commit()
        }
    }

    private fun initBottomNavigation() {
        binding.bnvHome.setOnItemSelectedListener {
            val screenEnum = BottomNavigationType.getScreenEnum(it.itemId)

            when (screenEnum) {
                BottomNavigationType.HOME -> {
                    replaceFragment(HomeFragment())
                    true
                }

                BottomNavigationType.SEARCH -> {
                    replaceFragment(SearchFragment())
                    true
                }

                BottomNavigationType.LIBRARY -> {
                    replaceFragment(LibraryFragment())
                    true
                }

                BottomNavigationType.PREMIUM -> {
                    replaceFragment(PremiumFragment())
                    true
                }
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fcv_home, fragment)
            .commit()
    }
}
