package com.nowsopt.spotify.presentation.main.artist.viewholder

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.nowsopt.spotify.databinding.ItemIncludedMusicBinding
import com.nowsopt.spotify.presentation.main.artist.model.ArtistModel.MockIncludedMusic

class IncludedMusicViewHolder(
    private val binding: ItemIncludedMusicBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(mockIncludedMusic: MockIncludedMusic) {
        with(binding) {
            tvIncludedTitle.text = mockIncludedMusic.title
            tvIncludedRelease.text = mockIncludedMusic.release.toString()
            ivIncludedMusic.load(mockIncludedMusic.imageUrl)
        }
    }
}