package com.nowsopt.spotify.presentation.main.home.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nowsopt.spotify.databinding.ItemHomeMainListenableShowBinding
import com.nowsopt.spotify.databinding.ItemHomeMainPopularArtistBinding
import com.nowsopt.spotify.databinding.ItemHomeMainPopularRadioBinding
import com.nowsopt.spotify.databinding.ItemHomeMainRecentPlayBinding
import com.nowsopt.spotify.databinding.ItemHomeMainRecommendMixBinding
import com.nowsopt.spotify.databinding.ItemHomeMainTodayHitSongBinding

class HomeMainAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val TYPE_RECOMMEND_MIX = 0
        const val TYPE_TODAY_HIT_SONG = 1
        const val TYPE_POPULAR_ARTIST = 2
        const val TYPE_RECENT_PLAY = 3
        const val TYPE_LISTENABLE_SHOW = 4
        const val TYPE_POPULAR_RADIO = 5
    }

    private var items: List<Any> = listOf()
    fun setItems(
        recommendMix: List<HomeMainModel.RecommendMix>?,
        todayHitSong: List<HomeMainModel.TodayHitSong>?,
        popularArtist: List<HomeMainModel.PopularArtist>?,
        recentPlay: List<HomeMainModel.RecentPlay>?,
        listenableShow: List<HomeMainModel.ListenableShow>?,
        popularRadio: List<HomeMainModel.PopularRadio>?
    ) {
        items = listOfNotNull(
            recommendMix,
            todayHitSong,
            popularArtist,
            recentPlay,
            listenableShow,
            popularRadio
        ).flatten()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
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

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is HomeMainViewHolder.RecommendMixViewHolder -> {
                (items[position] as? HomeMainModel.RecommendMix)?.let { holder.onBind(it) }
            }
            is HomeMainViewHolder.TodayHitSongViewHolder -> {
                (items[position] as? HomeMainModel.TodayHitSong)?.let { holder.onBind(it) }
            }
            is HomeMainViewHolder.PopularArtistViewHolder -> {
                (items[position] as? HomeMainModel.PopularArtist)?.let { holder.onBind(it) }
            }
            is HomeMainViewHolder.RecentPlayViewHolder -> {
                (items[position] as? HomeMainModel.RecentPlay)?.let { holder.onBind(it) }
            }
            is HomeMainViewHolder.ListenableShowViewHolder -> {
                (items[position] as? HomeMainModel.ListenableShow)?.let { holder.onBind(it) }
            }
            is HomeMainViewHolder.PopularRadioViewHolder -> {
                (items[position] as? HomeMainModel.PopularRadio)?.let { holder.onBind(it) }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is HomeMainModel.RecommendMix -> TYPE_RECOMMEND_MIX
            is HomeMainModel.TodayHitSong -> TYPE_TODAY_HIT_SONG
            is HomeMainModel.PopularArtist -> TYPE_POPULAR_ARTIST
            is HomeMainModel.RecentPlay -> TYPE_RECENT_PLAY
            is HomeMainModel.ListenableShow -> TYPE_LISTENABLE_SHOW
            is HomeMainModel.PopularRadio -> TYPE_POPULAR_RADIO
            else -> throw IllegalArgumentException("Invalid item type")
        }
    }

    override fun getItemCount(): Int = items.size
}
