package com.nowsopt.spotify.presentation.main

import android.view.LayoutInflater
import android.view.ViewGroup
import com.nowsopt.spotify.databinding.FragmentHomeBinding
import com.nowsopt.spotify.databinding.FragmentHomeMainBinding
import com.nowsopt.spotify.databinding.FragmentLibraryBinding
import com.nowsopt.spotify.databinding.FragmentSearchBinding
import com.nowsopt.spotify.util.base.BindingFragment

class HomeMainFragment : BindingFragment<FragmentHomeMainBinding>() {
    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): FragmentHomeMainBinding = FragmentHomeMainBinding.inflate(inflater, container, false)

}
