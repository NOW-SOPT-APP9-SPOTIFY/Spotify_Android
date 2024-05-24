package com.nowsopt.spotify.presentation.main.artist.viewholder

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.nowsopt.spotify.R
import com.nowsopt.spotify.databinding.ItemPopularAlbumBinding
import com.nowsopt.spotify.presentation.main.artist.model.ArtistModel.MockPopularAlbumModel

class PopularAlbumViewHolder(
    private val binding: ItemPopularAlbumBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(mockPopularAlbumModel: MockPopularAlbumModel) {
        with(binding) {
            tvPopularAlbum.text = mockPopularAlbumModel.title
            tvPopularAlbumRelease.text =
                itemView.context.getString(
                    R.string.popular_album_release,
                    mockPopularAlbumModel.release.toString()
                )
            when (mockPopularAlbumModel.id) {
                1 -> ivPopularAlbum.load(R.drawable.img_chart_songs_1_3)
                2 -> ivPopularAlbum.load(R.drawable.img_chart_songs_2_5_7_9_25)
                4 -> ivPopularAlbum.load(R.drawable.img_chart_songs_4_8)
                else -> ivPopularAlbum.load(R.drawable.img_chart_songs_6)
            }
        }
    }
}