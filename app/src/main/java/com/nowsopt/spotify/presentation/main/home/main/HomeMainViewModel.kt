package com.nowsopt.spotify.presentation.main.home.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nowsopt.spotify.R
import com.nowsopt.spotify.data.ServicePool
import com.nowsopt.spotify.data.model.response.HitSongs
import com.nowsopt.spotify.data.model.response.Playlists
import com.nowsopt.spotify.data.model.response.PopularArtist
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeMainViewModel : ViewModel() {

    private val _recommendMix = MutableStateFlow<List<Playlists.Playlist>>(emptyList())
    val recommendMix: StateFlow<List<Playlists.Playlist>> get() = _recommendMix

    private val _hitSong = MutableStateFlow<List<HitSongs.HitSong>>(emptyList())
    val hitSong: StateFlow<List<HitSongs.HitSong>> get() = _hitSong

    private val _popularArtists = MutableStateFlow<List<PopularArtist>>(emptyList())
    val popularArtist: StateFlow<List<PopularArtist>> get() = _popularArtists

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
                ServicePool.homeMainService.getTodayHitSongs()
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
                _popularArtists.value += popularArtists.data
            }.onFailure {
                it.printStackTrace()
            }
        }
    }

    val recentPlay = listOf(
        HomeMainModel.RecentPlay(
            imageUrl = R.drawable.img_recent_play_1,
            title = "title1"
        ),
        HomeMainModel.RecentPlay(
            imageUrl = R.drawable.img_recent_play_2,
            title = "title2"
        ),
        HomeMainModel.RecentPlay(
            imageUrl = R.drawable.img_recent_play_3,
            title = "title3"
        ),
        HomeMainModel.RecentPlay(
            imageUrl = R.drawable.img_recent_play_4,
            title = "title4"
        ),
    )

    val listenableShow = listOf(
        HomeMainModel.ListenableShow(
            imageUrl = R.drawable.img_listenable_show_1,
            genre = "genre1",
            title = "title1",
            artist = "artist1"
        ),
        HomeMainModel.ListenableShow(
            imageUrl = R.drawable.img_listenable_show_2,
            genre = "genre2",
            title = "title2",
            artist = "artist2"
        ),
        HomeMainModel.ListenableShow(
            imageUrl = R.drawable.img_listenable_show_3,
            genre = "genre3",
            title = "title3",
            artist = "artist3"
        ),
        HomeMainModel.ListenableShow(
            imageUrl = R.drawable.img_listenable_show_4,
            genre = "genre4",
            title = "title4",
            artist = "artist4"
        ),
    )

    val popularRadio = listOf(
        HomeMainModel.PopularRadio(
            imageUrl = R.drawable.img_popular_radio_1,
            artists = "artists1"
        ),
        HomeMainModel.PopularRadio(
            imageUrl = R.drawable.img_popular_radio_2,
            artists = "artists2"
        ),
        HomeMainModel.PopularRadio(
            imageUrl = R.drawable.img_popular_radio_3,
            artists = "artists3"
        ),
        HomeMainModel.PopularRadio(
            imageUrl = R.drawable.img_popular_radio_4,
            artists = "artists4"
        ),
    )
}