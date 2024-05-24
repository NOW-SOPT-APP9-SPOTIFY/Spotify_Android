package com.nowsopt.spotify.presentation.main.artist.viewholder

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.nowsopt.spotify.R
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
            when (data.id) {
                1, 3 -> ivMusic.load(R.drawable.img_chart_songs_1_3)
                2, 5, 7, 9, 25 -> ivMusic.load(R.drawable.img_chart_songs_2_5_7_9_25)
                4, 8 -> ivMusic.load(R.drawable.img_chart_songs_4_8)
                else -> ivMusic.load(R.drawable.img_chart_songs_6)
            }
        }
    }
}