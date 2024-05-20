package com.nowsopt.spotify.presentation.main.artist.viewholder

import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.nowsopt.spotify.R
import com.nowsopt.spotify.databinding.ItemOtherMusicBinding
import com.nowsopt.spotify.presentation.main.artist.ArtistModel.MockOtherMusic

class OtherMusicViewHolder(
    private val binding: ItemOtherMusicBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(mockOtherMusic: MockOtherMusic) {
        with(binding) {
            tvOtherArtist.text = mockOtherMusic.name
            ivOtherArtist.load(R.drawable.img_other_music) {
                transformations(CircleCropTransformation())
            }
        }
    }
}