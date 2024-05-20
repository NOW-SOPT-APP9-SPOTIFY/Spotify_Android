package com.nowsopt.spotify.presentation.main.artist.other

import androidx.recyclerview.widget.RecyclerView
import com.nowsopt.spotify.databinding.ItemOtherMusicBinding
import com.nowsopt.spotify.presentation.main.artist.ArtistModel.MockOtherMusic

class OtherMusicViewHolder(
    private val binding: ItemOtherMusicBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(mockOtherMusic: MockOtherMusic) {
        with(binding) {
            tvOtherArtist.text = mockOtherMusic.name
        }
    }
}