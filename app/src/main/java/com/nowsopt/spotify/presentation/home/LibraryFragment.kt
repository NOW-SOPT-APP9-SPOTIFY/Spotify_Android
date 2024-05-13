package com.nowsopt.spotify.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import com.nowsopt.spotify.databinding.FragmentLibraryBinding
import com.nowsopt.spotify.util.base.BindingFragment

class LibraryFragment : BindingFragment<FragmentLibraryBinding>() {
    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): FragmentLibraryBinding = FragmentLibraryBinding.inflate(inflater, container, false)

}
