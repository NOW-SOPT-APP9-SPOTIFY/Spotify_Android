package com.nowsopt.spotify.presentation.main.home.main

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.nowsopt.spotify.databinding.ItemHomeMainListenableShowBinding
import com.nowsopt.spotify.databinding.ItemHomeMainPopularArtistBinding
import com.nowsopt.spotify.databinding.ItemHomeMainPopularRadioBinding
import com.nowsopt.spotify.databinding.ItemHomeMainRecentPlayBinding
import com.nowsopt.spotify.databinding.ItemHomeMainRecommendMixBinding
import com.nowsopt.spotify.databinding.ItemHomeMainTodayHitSongBinding

class HomeMainViewHolder {

    class RecommendMixViewHolder(
        private val binding: ItemHomeMainRecommendMixBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(recommendMix: HomeMainModel.RecommendMix) {
            with(binding) {
                ivHomeMainRecommendMixAlbum.load(recommendMix.imageUrl) // R.drawable 형태
                tvHomeMainRecommendMixTheme.text = recommendMix.theme
                tvHomeMainRecommendMixArtist.text = recommendMix.artists.joinToString(separator = ", ")
            }
        }
    }

    class TodayHitSongViewHolder(
        private val binding: ItemHomeMainTodayHitSongBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(todayHitSong: HomeMainModel.TodayHitSong) {
            with(binding) {
                ivHomeMainTodayHitSongAlbum.load(todayHitSong.imageUrl)
                tvHomeMainTodayHitSongTitle.text = todayHitSong.title
                tvHomeMainTodayHitSongArtist.text = todayHitSong.artist
            }
        }
    }

    class PopularArtistViewHolder(
        private val binding: ItemHomeMainPopularArtistBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(popularArtist: HomeMainModel.PopularArtist) {
            with(binding) {
                ivHomeMainPopularArtistAlbum.load(popularArtist.imageUrl)
                tvHomeMainPopularArtistArtist.text = popularArtist.artist
            }
        }
    }

    class RecentPlayViewHolder(
        private val binding: ItemHomeMainRecentPlayBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(recentPlay: HomeMainModel.RecentPlay) {
            with(binding) {
                ivHomeMainRecentPlayAlbum.load(recentPlay.imageUrl)
                tvHomeMainRecentPlayTitle.text = recentPlay.title
            }
        }
    }

    class ListenableShowViewHolder(
        private val binding: ItemHomeMainListenableShowBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(listenableShow: HomeMainModel.ListenableShow) {
            with(binding) {
                ivHomeMainListenableShowAlbum.load(listenableShow.imageUrl)
                tvHomeMainListenableShowGenre.text = listenableShow.genre
                tvHomeMainListenableShowTitle.text = listenableShow.title
                tvHomeMainListenableShowArtist.text = listenableShow.artist
            }
        }
    }

    class PopularRadioViewHolder(
        private val binding: ItemHomeMainPopularRadioBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(popularRadio: HomeMainModel.PopularRadio) {
            with(binding) {
                ivHomeMainPopularRadioAlbum.load(popularRadio.imageUrl)
                tvHomeMainPopularRadioArtist.text = popularRadio.artists
            }
        }
    }
}