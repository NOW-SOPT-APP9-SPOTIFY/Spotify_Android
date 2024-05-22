package com.nowsopt.spotify.presentation.main.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nowsopt.spotify.data.ServicePool.artistService
import com.nowsopt.spotify.presentation.main.artist.model.ArtistDetailResponse
import com.nowsopt.spotify.presentation.main.artist.model.ArtistModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArtistViewModel : ViewModel() {
    val popularAlbumData = listOf(
        ArtistModel.MockPopularAlbumModel(
            title = "title1",
            release = 2012
        ),
        ArtistModel.MockPopularAlbumModel(
            title = "title2",
            release = 2020
        ),
        ArtistModel.MockPopularAlbumModel(
            title = "title3",
            release = 2014
        ),
        ArtistModel.MockPopularAlbumModel(
            title = "title4",
            release = 2004
        ),
        ArtistModel.MockPopularAlbumModel(
            title = "title5",
            release = 2010
        )
    )
    val genreData = listOf(
        ArtistModel.MockArtistGenreModel(
            imageUrl = "imageUrl",
            title = "title1",
            description = "This is Bruno Mars. 꼭 들어야 하는 트랙을 하나의 플레이리스트"
        ),
        ArtistModel.MockArtistGenreModel(
            imageUrl = "imageUrl",
            title = "title2",
            description = "This is Bruno Mars. 꼭 들어야 하는 트랙을 하나의 플레이리스트"
        ),
        ArtistModel.MockArtistGenreModel(
            imageUrl = "imageUrl",
            title = "title3",
            description = "This is Bruno Mars. 꼭 들어야 하는 트랙을 하나의 플레이리스트"
        ),
        ArtistModel.MockArtistGenreModel(
            imageUrl = "imageUrl",
            title = "title4",
            description = "This is Bruno Mars. 꼭 들어야 하는 트랙을 하나의 플레이리스트"
        )
    )
    val playlistData = listOf(
        ArtistModel.MockPlaylistModel(
            imageUrl = "imageUrl",
            title = "title1"
        ),
        ArtistModel.MockPlaylistModel(
            imageUrl = "imageUrl",
            title = "title2"
        ),
        ArtistModel.MockPlaylistModel(
            imageUrl = "imageUrl",
            title = "title3"
        )
    )
    val otherMusicData = listOf(
        ArtistModel.MockOtherMusic(
            imageUrl = "imageUrl",
            name = "name1"
        ),
        ArtistModel.MockOtherMusic(
            imageUrl = "imageUrl",
            name = "name2"
        ),
        ArtistModel.MockOtherMusic(
            imageUrl = "imageUrl",
            name = "name3"
        )
    )
    val includedMusicData = listOf(
        ArtistModel.MockIncludedMusic(
            imageUrl = "imageUrl",
            title = "title1",
            release = 2012
        ),
        ArtistModel.MockIncludedMusic(
            imageUrl = "imageUrl",
            title = "title2",
            release = 2004
        ),
        ArtistModel.MockIncludedMusic(
            imageUrl = "imageUrl",
            title = "title3",
            release = 2024
        )
    )

    private val _detail = MutableStateFlow<ArtistDetailResponse?>(null)
    val detail: StateFlow<ArtistDetailResponse?> get() = _detail

    fun getArtistDetail(artistId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                artistService.getArtistDetail(artistId)
            }.onSuccess { response ->
                _detail.value = response.body()?.data
            }.onFailure {
                it.printStackTrace()
            }
        }
    }


}