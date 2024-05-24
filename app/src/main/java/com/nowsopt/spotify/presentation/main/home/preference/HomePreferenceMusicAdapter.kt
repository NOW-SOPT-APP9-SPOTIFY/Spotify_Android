package com.nowsopt.spotify.presentation.main.home.preference

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.nowsopt.spotify.data.model.response.Albums
import com.nowsopt.spotify.databinding.ItemHomePreferenceMusicBinding
import com.nowsopt.spotify.util.ItemDiffCallback

class HomePreferenceMusicAdapter(
    context: Context,
    private val onClick: (Albums.Album) -> Unit,
) : ListAdapter<Albums.Album, HomePreferenceMusicViewHolder>(
    ItemDiffCallback<Albums.Album>(
        onContentsTheSame = { old, new -> old == new },
        onItemsTheSame = { old, new -> old.id == new.id },
    ),
) {
    private val inflater by lazy { LayoutInflater.from(context) }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): HomePreferenceMusicViewHolder =
        HomePreferenceMusicViewHolder(
            binding = ItemHomePreferenceMusicBinding.inflate(inflater, parent, false),
            onClick = onClick,
        )

    override fun onBindViewHolder(holder: HomePreferenceMusicViewHolder, position: Int) {
        holder.onBind(currentList[position])
    }

    override fun getItemCount() = currentList.size
}