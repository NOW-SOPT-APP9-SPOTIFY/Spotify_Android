package com.nowsopt.spotify.presentation.main.artist.model

import androidx.annotation.DrawableRes

sealed class ArtistModel {
    data class MockPopularAlbumModel(
        val id: Int,
        val title: String,
        val release: Int
    ): ArtistModel()

    data class MockArtistGenreModel(
        @DrawableRes val imageUrl: Int,
        val title: String,
        val description: String
    ): ArtistModel()

    data class MockIncludedMusic(
        @DrawableRes val imageUrl: Int,
        val title: String,
        val release: Int
    ): ArtistModel()

    data class MockOtherMusic(
        @DrawableRes val imageUrl: Int,
        val name: String
    ): ArtistModel()

    data class MockPlaylistModel(
        @DrawableRes val imageUrl: Int,
        val title: String
    ): ArtistModel()

    data class MockPopularMusicModel(
        val number: Int,
        val imageUrl: String,
        val title: String,
        val like: Int
    ): ArtistModel()

}