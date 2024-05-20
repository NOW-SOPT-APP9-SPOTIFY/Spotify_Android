package com.nowsopt.spotify.presentation.main.artist.genre

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.nowsopt.spotify.databinding.ItemArtistGenreBinding
import com.nowsopt.spotify.util.ItemDiffCallback

class ArtistGenreAdapter(
    context: Context
) : ListAdapter<MockArtistGenreModel, ArtistGenreViewHolder>(
    ItemDiffCallback<MockArtistGenreModel>(
        onContentsTheSame = { old, new -> old == new },
        onItemsTheSame = { old, new -> old.title == new.title }
    )
) {
    private val inflater by lazy { LayoutInflater.from(context) }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ArtistGenreViewHolder =
        ArtistGenreViewHolder(
            binding = ItemArtistGenreBinding.inflate(inflater, parent, false)
        )

    override fun onBindViewHolder(holder: ArtistGenreViewHolder, position: Int) {
        holder.onBind(currentList[position])
    }

    override fun getItemCount(): Int = currentList.size
}