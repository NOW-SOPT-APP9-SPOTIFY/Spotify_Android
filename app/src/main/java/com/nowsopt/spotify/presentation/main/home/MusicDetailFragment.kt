package com.nowsopt.spotify.presentation.main.home

import android.view.LayoutInflater
import android.view.ViewGroup
import com.nowsopt.spotify.databinding.FragmentMusicDetailBinding
import com.nowsopt.spotify.util.base.BindingFragment

class MusicDetailFragment : BindingFragment<FragmentMusicDetailBinding>() {
    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): FragmentMusicDetailBinding = FragmentMusicDetailBinding.inflate(inflater, container, false)

}
