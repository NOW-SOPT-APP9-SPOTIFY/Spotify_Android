package com.nowsopt.spotify.presentation.main.home.main

sealed class HomeMainModel {
    data class RecommendMix(
        val imageUrl: String,
        val theme: String,
        val artists: String
    ) : HomeMainModel()

    data class TodayHitSong(
        val imageUrl: String,
        val title: String,
        val artist: String
    ) : HomeMainModel()

    data class PopularArtist(
        val imageUrl: String,
        val artist: String
    ) : HomeMainModel()

    data class RecentPlay(
        val imageUrl: String,
        val title: String
    ) : HomeMainModel()

    data class ListenableShow(
        val imageUrl: String,
        val genre: String,
        val title: String,
        val artist: String
    ) : HomeMainModel()

    data class PopularRadio(
        val imageUrl: String,
        val artists: String
    ) : HomeMainModel()
}