package com.nowsopt.spotify.presentation.main.artist.genre

import androidx.recyclerview.widget.RecyclerView
import com.nowsopt.spotify.databinding.ItemArtistGenreBinding

class ArtistGenreViewHolder(
    private val binding: ItemArtistGenreBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(mockArtistGenreModel: MockArtistGenreModel) {
        with(binding) {
            tvGenreTitle.text = mockArtistGenreModel.title
            tvGenreDescription.text = mockArtistGenreModel.description
        }
    }
}