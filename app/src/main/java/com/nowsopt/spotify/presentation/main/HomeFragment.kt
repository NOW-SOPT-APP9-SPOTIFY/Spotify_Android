package com.nowsopt.spotify.presentation.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.nowsopt.spotify.databinding.FragmentHomeBinding
import com.nowsopt.spotify.util.base.BindingFragment

class HomeFragment : BindingFragment<FragmentHomeBinding>() {
    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): FragmentHomeBinding = FragmentHomeBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.chipCh.setOnClickListener {
            binding.chipX.isVisible = true
            binding.chipPodcast.isVisible = false
            binding.chipHeart.isVisible = false
        }
        binding.chipX.setOnClickListener {
            binding.chipX.isVisible = false
            binding.chipCh.isVisible = true
            binding.chipPodcast.isVisible = true
            binding.chipHeart.isVisible = true
        }
    }
}
