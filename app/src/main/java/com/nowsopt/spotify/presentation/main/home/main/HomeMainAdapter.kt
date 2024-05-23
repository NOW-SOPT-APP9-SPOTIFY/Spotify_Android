package com.nowsopt.spotify.presentation.main.home.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.nowsopt.spotify.databinding.ItemHomeMainListenableShowBinding
import com.nowsopt.spotify.databinding.ItemHomeMainPopularArtistBinding
import com.nowsopt.spotify.databinding.ItemHomeMainPopularRadioBinding
import com.nowsopt.spotify.databinding.ItemHomeMainRecentPlayBinding
import com.nowsopt.spotify.databinding.ItemHomeMainRecommendMixBinding
import com.nowsopt.spotify.databinding.ItemHomeMainTodayHitSongBinding

class HomeMainAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val TYPE_RECOMMEND_MIX = 0
        const val TYPE_TODAY_HIT_SONG = 1
        const val TYPE_POPULAR_ARTIST = 2
        const val TYPE_RECENT_PLAY = 3
        const val TYPE_LISTENABLE_SHOW = 4
        const val TYPE_POPULAR_RADIO = 5
    }

    private var items: List<Pair<Int, Any>> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            TYPE_RECOMMEND_MIX -> {
                val binding = ItemHomeMainRecommendMixBinding.inflate(inflater, parent, false)
                HomeMainViewHolder.RecommendMixViewHolder(binding)
            }
            TYPE_TODAY_HIT_SONG -> {
                val binding = ItemHomeMainTodayHitSongBinding.inflate(inflater, parent, false)
                HomeMainViewHolder.TodayHitSongViewHolder(binding)
            }
            TYPE_POPULAR_ARTIST -> {
                val binding = ItemHomeMainPopularArtistBinding.inflate(inflater, parent, false)
                HomeMainViewHolder.PopularArtistViewHolder(binding)
            }
            TYPE_RECENT_PLAY -> {
                val binding = ItemHomeMainRecentPlayBinding.inflate(inflater, parent, false)
                HomeMainViewHolder.RecentPlayViewHolder(binding)
            }
            TYPE_LISTENABLE_SHOW -> {
                val binding = ItemHomeMainListenableShowBinding.inflate(inflater, parent, false)
                HomeMainViewHolder.ListenableShowViewHolder(binding)
            }
            TYPE_POPULAR_RADIO -> {
                val binding = ItemHomeMainPopularRadioBinding.inflate(inflater, parent, false)
                HomeMainViewHolder.PopularRadioViewHolder(binding)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position].second
        when (holder) {
            is HomeMainViewHolder.RecommendMixViewHolder -> holder.onBind(item as HomeMainModel.RecommendMix)
            is HomeMainViewHolder.TodayHitSongViewHolder -> holder.onBind(item as HomeMainModel.TodayHitSong)
            is HomeMainViewHolder.PopularArtistViewHolder -> holder.onBind(item as HomeMainModel.PopularArtist)
            is HomeMainViewHolder.RecentPlayViewHolder -> holder.onBind(item as HomeMainModel.RecentPlay)
            is HomeMainViewHolder.ListenableShowViewHolder -> holder.onBind(item as HomeMainModel.ListenableShow)
            is HomeMainViewHolder.PopularRadioViewHolder -> holder.onBind(item as HomeMainModel.PopularRadio)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return items[position].first
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun <T : Any> setItems(type: Int, data: List<T>) {
        items = items.filterNot { it.first == type } + data.map { type to it }
        notifyDataSetChanged()
    }

    fun <T : Any> updateItems(type: Int, data: List<T>) {
        items = items.filterNot { it.first == type } + data.map { type to it }
        notifyDataSetChanged()
    }
}

