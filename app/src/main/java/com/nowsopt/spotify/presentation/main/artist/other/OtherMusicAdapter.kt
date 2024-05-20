package com.nowsopt.spotify.presentation.main.artist.other

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.nowsopt.spotify.databinding.ItemOtherMusicBinding
import com.nowsopt.spotify.util.ItemDiffCallback

class OtherMusicAdapter(
    context: Context
) : ListAdapter<MockOtherMusic, OtherMusicViewHolder>(
    ItemDiffCallback<MockOtherMusic>(
        onContentsTheSame = { old, new -> old == new },
        onItemsTheSame = { old, new -> old.name == new.name }
    )
) {
    private val inflater by lazy { LayoutInflater.from(context) }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OtherMusicViewHolder =
        OtherMusicViewHolder(
            binding = ItemOtherMusicBinding.inflate(inflater, parent, false)
        )

    override fun onBindViewHolder(holder: OtherMusicViewHolder, position: Int) {
        holder.onBind(currentList[position])
    }

    override fun getItemCount(): Int = currentList.size
}