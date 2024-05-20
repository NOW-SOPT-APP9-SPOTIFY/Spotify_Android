package com.nowsopt.spotify.presentation.main

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.nowsopt.spotify.R
import com.nowsopt.spotify.databinding.ActivityMainBinding
import com.nowsopt.spotify.util.base.BindingActivity

class MainActivity : BindingActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fcv_home) as NavHostFragment
        navController = navHostFragment.navController

        // 바텀 네비게이션 연결
        binding.bnvHome.setupWithNavController(navController)

        setBottomClickListener()
    }

    private fun setBottomClickListener() {
        binding.bnvHome.setOnItemSelectedListener { item ->
            NavigationUI.onNavDestinationSelected(item, navController)
            return@setOnItemSelectedListener true
        }
    }
}
