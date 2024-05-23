package com.nowsopt.spotify.presentation.main.artist.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.nowsopt.spotify.databinding.ItemPopularMusicBinding
import com.nowsopt.spotify.presentation.main.artist.model.Song
import java.text.DecimalFormat

class ArtistDetailViewHolder(
    private val binding: ItemPopularMusicBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(data: Song, position: Int) {
        with(binding) {
            tvMusicNumber.text = (position + 1).toString()
            tvMusicTitle.text = data.title
            tvMusicLike.text = DecimalFormat("#,###").format(data.listenedCount)
        }
    }
}