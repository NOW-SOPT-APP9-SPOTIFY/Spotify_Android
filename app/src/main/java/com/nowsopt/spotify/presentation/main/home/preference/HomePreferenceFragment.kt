package com.nowsopt.spotify.presentation.main.home.preference

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nowsopt.spotify.databinding.FragmentHomePreferenceBinding
import com.nowsopt.spotify.util.base.BindingFragment

class HomePreferenceFragment : BindingFragment<FragmentHomePreferenceBinding>() {
    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): FragmentHomePreferenceBinding =
        FragmentHomePreferenceBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = HomePreferenceMusicAdapter(requireContext()) { mockMusicModel ->

        }

        adapter.submitList(
            listOf(
                MockMusicModel(
                    title = "title1",
                    artist = "artist",
                    album = "album",
                    imageUrl = "imageUrl",
                    isBookmark = false
                ),
                MockMusicModel(
                    title = "title2",
                    artist = "artist",
                    album = "album",
                    imageUrl = "imageUrl",
                    isBookmark = false
                ),
                MockMusicModel(
                    title = "title3",
                    artist = "artist",
                    album = "album",
                    imageUrl = "imageUrl",
                    isBookmark = false
                ),
            )
        )

        binding.rvHomePreference.adapter = adapter
    }
}
