package com.nowsopt.spotify.presentation.main.artist.playlist

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.nowsopt.spotify.databinding.ItemArtistPlaylistBinding
import com.nowsopt.spotify.util.ItemDiffCallback

class PlaylistAdapter(
    context: Context
) : ListAdapter<MockPlaylistModel, PlaylistViewHolder>(
    ItemDiffCallback<MockPlaylistModel>(
        onContentsTheSame = { old, new -> old == new },
        onItemsTheSame = { old, new -> old.title == new.title }
    )
) {
    private val inflater by lazy { LayoutInflater.from(context) }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PlaylistViewHolder =
        PlaylistViewHolder(
            binding = ItemArtistPlaylistBinding.inflate(inflater, parent, false)
        )

    override fun onBindViewHolder(holder: PlaylistViewHolder, position: Int) {
        holder.onBind(currentList[position])
    }

    override fun getItemCount(): Int = currentList.size
}