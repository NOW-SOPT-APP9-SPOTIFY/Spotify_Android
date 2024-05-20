package com.nowsopt.spotify.presentation.main.artist.playlist

import androidx.recyclerview.widget.RecyclerView
import com.nowsopt.spotify.databinding.ItemArtistPlaylistBinding
import com.nowsopt.spotify.presentation.main.artist.ArtistModel.MockPlaylistModel

class PlaylistViewHolder(
    private val binding: ItemArtistPlaylistBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(mockPlaylistModel: MockPlaylistModel) {
        with(binding) {
            tvPlaylist.text = mockPlaylistModel.title
        }
    }
}