package com.nowsopt.spotify.presentation.main.artist

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.nowsopt.spotify.databinding.ItemPopularMusicBinding
import com.nowsopt.spotify.presentation.main.artist.model.Song
import com.nowsopt.spotify.presentation.main.artist.viewholder.ArtistDetailViewHolder
import com.nowsopt.spotify.util.ItemDiffCallback

class ArtistDetailAdapter(
    context: Context
): ListAdapter<Song, ArtistDetailViewHolder>(
    ItemDiffCallback<Song>(
        onContentsTheSame = { old, new -> old == new },
        onItemsTheSame = { old, new -> old == new }
    )
) {
    private val inflater by lazy { LayoutInflater.from(context) }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ArtistDetailViewHolder =
        ArtistDetailViewHolder(
            binding = ItemPopularMusicBinding.inflate(inflater, parent, false)
        )

    override fun onBindViewHolder(holder: ArtistDetailViewHolder, position: Int) {
        holder.onBind(currentList[position], position)
    }

    override fun getItemCount(): Int = currentList.size
}
