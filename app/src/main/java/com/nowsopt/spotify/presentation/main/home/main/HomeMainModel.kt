package com.nowsopt.spotify.presentation.main.home.main

import androidx.annotation.DrawableRes

sealed class HomeMainModel {
    data class RecommendMix(
        @DrawableRes val imageUrl: Int,
        val theme: String,
        val artists: List<String>
    ) : HomeMainModel()

    data class TodayHitSong(
        @DrawableRes val imageUrl: Int,
        val title: String,
        val artist: String
    ) : HomeMainModel()

    data class PopularArtist(
        @DrawableRes val imageUrl: Int,
        val artist: String
    ) : HomeMainModel()

    data class RecentPlay(
        @DrawableRes val imageUrl: Int,
        val title: String
    ) : HomeMainModel()

    data class ListenableShow(
        @DrawableRes val imageUrl: Int,
        val genre: String,
        val title: String,
        val artist: String
    ) : HomeMainModel()

    data class PopularRadio(
        @DrawableRes val imageUrl: Int,
        val artists: String
    ) : HomeMainModel()
}