package com.nowsopt.spotify.presentation.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
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

        initBottomNavigation()
    }

    private fun initBottomNavigation() {
        binding.bnvHome.setOnItemSelectedListener {
            val screenEnum = BottomNavigationType.getScreenEnum(it.itemId)

            when (screenEnum) {
                BottomNavigationType.HOME -> {
                    findNavController(binding.fcvHome.id).navigate(R.id.home_navigation)
                    true
                }

                BottomNavigationType.SEARCH -> {
                    findNavController(binding.fcvHome.id).navigate(R.id.search_navigation)
                    true
                }

                BottomNavigationType.LIBRARY -> {
                    findNavController(binding.fcvHome.id).navigate(R.id.library_navigation)
                    true
                }

                BottomNavigationType.PREMIUM -> {
                    findNavController(binding.fcvHome.id).navigate(R.id.premium_navigation)
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
