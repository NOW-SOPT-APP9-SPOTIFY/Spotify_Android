package com.nowsopt.spotify.presentation.main.home.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nowsopt.spotify.data.ServicePool
import com.nowsopt.spotify.data.model.response.Albums
import com.nowsopt.spotify.data.model.response.HitSongs
import com.nowsopt.spotify.data.model.response.Playlists
import com.nowsopt.spotify.data.model.response.PopularArtists
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeMainViewModel : ViewModel() {

    private val _recommendMix = MutableStateFlow<List<Playlists.Playlist>>(emptyList())
    val recommendMix: StateFlow<List<Playlists.Playlist>> get() = _recommendMix

    private val _hitSong = MutableStateFlow<List<HitSongs.HitSong>>(emptyList())
    val hitSong: StateFlow<List<HitSongs.HitSong>> get() = _hitSong

    private val _popularArtists = MutableStateFlow<List<PopularArtists.PopularArtist>>(emptyList())
    val popularArtist: StateFlow<List<PopularArtists.PopularArtist>> get() = _popularArtists

    fun getPlaylists() {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                ServicePool.homeMainService.getRecommendMix()
            }.onSuccess { playlists ->
                _recommendMix.value = playlists.data.playlists
            }.onFailure {
                it.printStackTrace()
            }
        }
    }

    fun getHitSongs() {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                ServicePool.homeMainService.getTodayHitSong()
            }.onSuccess { hitSongs ->
                _hitSong.value = hitSongs.data.hitSongs
            }.onFailure {
                it.printStackTrace()
            }
        }
    }

    fun getPopularArtists() {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                ServicePool.homeMainService.getPopularArtists()
            }.onSuccess { popularArtists ->
                _popularArtists.value = popularArtists.data.popularArtists
            }.onFailure {
                it.printStackTrace()
            }
        }
    }

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