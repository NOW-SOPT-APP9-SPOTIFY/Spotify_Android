package com.nowsopt.spotify.presentation.main.artist.popular

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.nowsopt.spotify.databinding.ItemPopularMusicBinding
import com.nowsopt.spotify.util.ItemDiffCallback
import com.nowsopt.spotify.presentation.main.artist.ArtistModel.MockPopularMusicModel

class PopularMusicAdapter(
    context: Context
) : ListAdapter<MockPopularMusicModel, PopularMusicViewHolder>(
    ItemDiffCallback<MockPopularMusicModel>(
        onContentsTheSame = { old, new -> old == new },
        onItemsTheSame = { old, new -> old.title == new.title }
    )
) {
    private val inflater by lazy { LayoutInflater.from(context) }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PopularMusicViewHolder =
        PopularMusicViewHolder(
            binding = ItemPopularMusicBinding.inflate(inflater, parent, false)
        )

    override fun onBindViewHolder(holder: PopularMusicViewHolder, position: Int) {
        holder.onBind(currentList[position])
    }

    override fun getItemCount(): Int = currentList.size
}