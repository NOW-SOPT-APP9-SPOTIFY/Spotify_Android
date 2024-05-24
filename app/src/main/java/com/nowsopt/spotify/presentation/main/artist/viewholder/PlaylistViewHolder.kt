package com.nowsopt.spotify.presentation.main.artist.viewholder

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.nowsopt.spotify.databinding.ItemArtistPlaylistBinding
import com.nowsopt.spotify.presentation.main.artist.model.ArtistModel.MockPlaylistModel

class PlaylistViewHolder(
    private val binding: ItemArtistPlaylistBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(mockPlaylistModel: MockPlaylistModel) {
        with(binding) {
            tvPlaylist.text = mockPlaylistModel.title
            ivPlaylist.load(mockPlaylistModel.imageUrl)
        }
    }
}