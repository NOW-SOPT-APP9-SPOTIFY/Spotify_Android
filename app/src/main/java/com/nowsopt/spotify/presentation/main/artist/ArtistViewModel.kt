package com.nowsopt.spotify.presentation.main.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nowsopt.spotify.R
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
            id = 1,
            title = "Unorthodox Jukebox",
            release = 2012
        ),
        ArtistModel.MockPopularAlbumModel(
            id = 4,
            title = "24K Magic",
            release = 2016
        ),
        ArtistModel.MockPopularAlbumModel(
            id = 2,
            title = "Doo-Wops & Hooligans",
            release = 2010
        ),
        ArtistModel.MockPopularAlbumModel(
            id = 6,
            title = "An Evening With Silk Sonic",
            release = 2021
        )
    )
    val genreData = listOf(
        ArtistModel.MockArtistGenreModel(
            imageUrl = R.drawable.img_genre_1,
            title = "This is Bruno Mars",
            description = "This is Bruno Mars. 꼭 들어야 하는 트랙을 하나의 플레이리스.."
        ),
        ArtistModel.MockArtistGenreModel(
            imageUrl = R.drawable.img_genre_2,
            title = "Bruno Mars 라디오",
            description = "Maroon5, Jason Derulo, Ne-yo 외 다양한 아티스트와 함께"
        ),
        ArtistModel.MockArtistGenreModel(
            imageUrl = R.drawable.img_genre_3,
            title = "Soft Pop Hits",
            description = "Warm familiar pop you know and loce.Cover:Adele"
        )
    )
    val playlistData = listOf(
        ArtistModel.MockPlaylistModel(
            imageUrl = R.drawable.img_playlist_1,
            title = "Bruno Mars - An Evening With Silk Sonic"
        ),
        ArtistModel.MockPlaylistModel(
            imageUrl = R.drawable.img_playlist_2,
            title = "Bruno Mars - Official Discography"
        ),
        ArtistModel.MockPlaylistModel(
            imageUrl = R.drawable.img_playlist_3,
            title = "Bruno Mars - Tour Setlist 2024"
        )
    )
    val otherMusicData = listOf(
        ArtistModel.MockOtherMusic(
            imageUrl = R.drawable.img_other_1,
            name = "Maroon 5"
        ),
        ArtistModel.MockOtherMusic(
            imageUrl = R.drawable.img_other_2,
            name = "Jason Derulo"
        ),
        ArtistModel.MockOtherMusic(
            imageUrl = R.drawable.img_other_3,
            name = " Ne-Yo"
        )
    )
    val includedMusicData = listOf(
        ArtistModel.MockIncludedMusic(
            imageUrl = R.drawable.img_included_1,
            title = "The Carter IV (Complete Edition)",
            release = 2011
        ),
        ArtistModel.MockIncludedMusic(
            imageUrl = R.drawable.img_included_2,
            title = "No.6 Collaborations Project",
            release = 2019
        ),
        ArtistModel.MockIncludedMusic(
            imageUrl = R.drawable.img_included_3,
            title = "Summer Party Anthems",
            release = 2011
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