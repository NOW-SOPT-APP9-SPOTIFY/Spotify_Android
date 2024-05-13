package com.nowsopt.spotify.presentation.main

import android.view.LayoutInflater
import android.view.ViewGroup
import com.nowsopt.spotify.databinding.FragmentHomeBinding
import com.nowsopt.spotify.util.base.BindingFragment

class HomeFragment : BindingFragment<FragmentHomeBinding>() {
    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): FragmentHomeBinding = FragmentHomeBinding.inflate(inflater, container, false)

}
