package com.nowsopt.spotify.presentation.main

import android.view.LayoutInflater
import android.view.ViewGroup
import com.nowsopt.spotify.databinding.FragmentPremiumBinding
import com.nowsopt.spotify.util.base.BindingFragment

class PremiumFragment : BindingFragment<FragmentPremiumBinding>() {
    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): FragmentPremiumBinding = FragmentPremiumBinding.inflate(inflater, container, false)

}
