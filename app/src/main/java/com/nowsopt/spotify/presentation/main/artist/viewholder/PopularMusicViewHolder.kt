package com.nowsopt.spotify.presentation.main.artist.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.nowsopt.spotify.databinding.ItemPopularMusicBinding
import java.text.DecimalFormat
import com.nowsopt.spotify.presentation.main.artist.ArtistModel.MockPopularMusicModel

class PopularMusicViewHolder(
    private val binding: ItemPopularMusicBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(mockPopularMusicModel: MockPopularMusicModel) {
        with(binding) {
            tvMusicNumber.text = mockPopularMusicModel.number.toString()
            tvMusicTitle.text = mockPopularMusicModel.title
            tvMusicLike.text = DecimalFormat("#,###").format(mockPopularMusicModel.like)
        }
    }
}