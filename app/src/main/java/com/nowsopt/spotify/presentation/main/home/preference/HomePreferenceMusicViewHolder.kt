package com.nowsopt.spotify.presentation.main.home.preference

import androidx.recyclerview.widget.RecyclerView
import com.nowsopt.spotify.databinding.ItemHomePreferenceMusicBinding

class HomePreferenceMusicViewHolder(
    private val binding: ItemHomePreferenceMusicBinding,
    private val onClick: (MockMusicModel) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(mockMusicModel: MockMusicModel) {
        with(binding){
            tvHomePreferenceMusicTitle.text = mockMusicModel.title
        }
    }
}
