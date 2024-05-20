package com.nowsopt.spotify.presentation.main.artist

sealed class ArtistModel {
    data class MockPopularAlbumModel(
        val title: String,
        val release: Int
    ): ArtistModel()

    data class MockArtistGenreModel(
        val imageUrl: String,
        val title: String,
        val description: String
    ): ArtistModel()

    data class MockIncludedMusic(
        val imageUrl: String,
        val title: String,
        val release: Int
    ): ArtistModel()

    data class MockOtherMusic(
        val imageUrl: String,
        val name: String
    ): ArtistModel()

    data class MockPlaylistModel(
        val imageUrl: String,
        val title: String
    ): ArtistModel()

    data class MockPopularMusicModel(
        val number: Int,
        val imageUrl: String,
        val title: String,
        val like: Int
    ): ArtistModel()

}