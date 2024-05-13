package com.nowsopt.spotify.presentation.home.home.preference

import android.view.LayoutInflater
import android.view.ViewGroup
import com.nowsopt.spotify.databinding.FragmentHomePreferenceBinding
import com.nowsopt.spotify.util.base.BindingFragment

class HomePreferenceFragment : BindingFragment<FragmentHomePreferenceBinding>() {
    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): FragmentHomePreferenceBinding =
        FragmentHomePreferenceBinding.inflate(inflater, container, false)
}
