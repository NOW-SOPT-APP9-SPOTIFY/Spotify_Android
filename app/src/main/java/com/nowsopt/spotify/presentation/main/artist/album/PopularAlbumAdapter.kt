package com.nowsopt.spotify.presentation.main.artist.album

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.nowsopt.spotify.databinding.ItemPopularAlbumBinding
import com.nowsopt.spotify.util.ItemDiffCallback

class PopularAlbumAdapter(
    context: Context
) : ListAdapter<MockPopularAlbumModel, PopularAlbumViewHolder>(
    ItemDiffCallback<MockPopularAlbumModel>(
        onContentsTheSame = { old, new -> old == new },
        onItemsTheSame = { old, new -> old.title == new.title }
    )
) {
    private val inflater by lazy { LayoutInflater.from(context) }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularAlbumViewHolder =
        PopularAlbumViewHolder(
            binding = ItemPopularAlbumBinding.inflate(inflater, parent, false)
        )

    override fun onBindViewHolder(holder: PopularAlbumViewHolder, position: Int) {
        holder.onBind(currentList[position])
    }

    override fun getItemCount(): Int = currentList.size
}