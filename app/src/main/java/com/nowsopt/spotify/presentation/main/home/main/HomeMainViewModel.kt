package com.nowsopt.spotify.presentation.main.home.main

import androidx.lifecycle.ViewModel

class HomeMainViewModel: ViewModel() {

    val recommendMix = listOf(
        HomeMainModel.RecommendMix(
            imageUrl = "imageUrl",
            theme = "Theme1",
            artists = "artist1"
        ),
        HomeMainModel.RecommendMix(
            imageUrl = "imageUrl",
            theme = "Theme2",
            artists = "artist2"
        ),
        HomeMainModel.RecommendMix(
            imageUrl = "imageUrl",
            theme = "Theme3",
            artists = "artist3"
        ),
        HomeMainModel.RecommendMix(
            imageUrl = "imageUrl",
            theme = "Theme4",
            artists = "artist4"
        ),
    )

    val todayHitSong = listOf(
        HomeMainModel.TodayHitSong(
            imageUrl = "imageUrl",
            title = "title1",
            artist = "artist1"
        ),
        HomeMainModel.TodayHitSong(
            imageUrl = "imageUrl",
            title = "title2",
            artist = "artist2"
        ),
        HomeMainModel.TodayHitSong(
            imageUrl = "imageUrl",
            title = "title3",
            artist = "artist3"
        ),
        HomeMainModel.TodayHitSong(
            imageUrl = "imageUrl",
            title = "title4",
            artist = "artist4"
        ),
    )

    val popularArtist = listOf(
        HomeMainModel.PopularArtist(
            imageUrl = "imageUrl",
            artist = "artist1"
        ),
        HomeMainModel.PopularArtist(
            imageUrl = "imageUrl",
            artist = "artist2"
        ),
        HomeMainModel.PopularArtist(
            imageUrl = "imageUrl",
            artist = "artist3"
        ),
        HomeMainModel.PopularArtist(
            imageUrl = "imageUrl",
            artist = "artist4"
        ),
    )

    val recentPlay = listOf(
        HomeMainModel.RecentPlay(
            imageUrl = "imageUrl",
            title = "title1"
        ),
        HomeMainModel.RecentPlay(
            imageUrl = "imageUrl",
            title = "title2"
        ),
        HomeMainModel.RecentPlay(
            imageUrl = "imageUrl",
            title = "title3"
        ),
        HomeMainModel.RecentPlay(
            imageUrl = "imageUrl",
            title = "title4"
        ),
        HomeMainModel.RecentPlay(
            imageUrl = "imageUrl",
            title = "title5"
        ),
        HomeMainModel.RecentPlay(
            imageUrl = "imageUrl",
            title = "title6"
        ),
    )

    val listenableShow = listOf(
        HomeMainModel.ListenableShow(
            imageUrl = "imageUrl",
            genre = "genre1",
            title = "title1",
            artist = "artist1"
        ),
        HomeMainModel.ListenableShow(
            imageUrl = "imageUrl",
            genre = "genre2",
            title = "title2",
            artist = "artist2"
        ),
        HomeMainModel.ListenableShow(
            imageUrl = "imageUrl",
            genre = "genre3",
            title = "title3",
            artist = "artist3"
        ),
        HomeMainModel.ListenableShow(
            imageUrl = "imageUrl",
            genre = "genre4",
            title = "title4",
            artist = "artist4"
        ),
    )

    val popularRadio = listOf(
        HomeMainModel.PopularRadio(
            imageUrl = "imageUrl",
            artists = "artists1"
        ),
        HomeMainModel.PopularRadio(
            imageUrl = "imageUrl",
            artists = "artists2"
        ),
        HomeMainModel.PopularRadio(
            imageUrl = "imageUrl",
            artists = "artists3"
        ),
        HomeMainModel.PopularRadio(
            imageUrl = "imageUrl",
            artists = "artists4"
        ),
    )
}