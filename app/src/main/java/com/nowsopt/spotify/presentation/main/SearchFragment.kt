package com.nowsopt.spotify.presentation.main

import android.view.LayoutInflater
import android.view.ViewGroup
import com.nowsopt.spotify.databinding.FragmentHomeBinding
import com.nowsopt.spotify.databinding.FragmentSearchBinding
import com.nowsopt.spotify.util.base.BindingFragment

class SearchFragment : BindingFragment<FragmentSearchBinding>() {
    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): FragmentSearchBinding = FragmentSearchBinding.inflate(inflater, container, false)

}
