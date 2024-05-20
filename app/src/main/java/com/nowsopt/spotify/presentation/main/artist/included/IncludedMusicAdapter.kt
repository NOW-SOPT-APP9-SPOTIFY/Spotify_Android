package com.nowsopt.spotify.presentation.main.artist.included

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.nowsopt.spotify.databinding.ItemIncludedMusicBinding
import com.nowsopt.spotify.util.ItemDiffCallback

class IncludedMusicAdapter(
    context: Context
) : ListAdapter<MockIncludedMusic, IncludedMusicViewHolder>(
    ItemDiffCallback<MockIncludedMusic>(
        onContentsTheSame = { old, new -> old == new },
        onItemsTheSame = { old, new -> old.title == new.title }
    )
) {
    private val inflater by lazy { LayoutInflater.from(context) }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): IncludedMusicViewHolder =
        IncludedMusicViewHolder(
            binding = ItemIncludedMusicBinding.inflate(inflater, parent, false)
        )

    override fun onBindViewHolder(holder: IncludedMusicViewHolder, position: Int) {
        holder.onBind(currentList[position])
    }

    override fun getItemCount(): Int = currentList.size
}