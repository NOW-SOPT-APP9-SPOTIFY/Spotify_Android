package com.nowsopt.spotify.presentation.main.artist.album

import androidx.recyclerview.widget.RecyclerView
import com.nowsopt.spotify.R
import com.nowsopt.spotify.databinding.ItemPopularAlbumBinding

class PopularAlbumViewHolder(
    private val binding: ItemPopularAlbumBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(mockPopularAlbumModel: MockPopularAlbumModel) {
        with(binding) {
            tvPopularAlbum.text = mockPopularAlbumModel.title
            tvPopularAlbumRelease.text =
                itemView.context.getString(R.string.popular_album_release, mockPopularAlbumModel.release.toString())
        }
    }
}