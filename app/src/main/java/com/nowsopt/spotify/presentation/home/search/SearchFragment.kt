package com.nowsopt.spotify.presentation.home.search

import android.view.LayoutInflater
import android.view.ViewGroup
import com.nowsopt.spotify.databinding.FragmentSearchBinding
import com.nowsopt.spotify.util.base.BindingFragment

class SearchFragment : BindingFragment<FragmentSearchBinding>() {
    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): FragmentSearchBinding = FragmentSearchBinding.inflate(inflater, container, false)

}
