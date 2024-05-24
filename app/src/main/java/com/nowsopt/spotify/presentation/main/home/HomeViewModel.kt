package com.nowsopt.spotify.presentation.main.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nowsopt.spotify.data.ServicePool.albumService
import com.nowsopt.spotify.data.model.response.Albums
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private var _currentTab: MutableStateFlow<HomeTab> = MutableStateFlow(HomeTab.MAIN)
    val currentTab: StateFlow<HomeTab> = _currentTab

    private val _recommendAlbums = MutableStateFlow<List<Albums.Album>>(emptyList())
    val recommendAlbums: StateFlow<List<Albums.Album>> get() = _recommendAlbums


    fun setCurrentTab(tab: HomeTab) {
        _currentTab.value = tab
    }

    fun getAlbums() {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                albumService.getRecommendAlbums()
            }.onSuccess { albums ->
                _recommendAlbums.value = albums.data.albums
            }.onFailure {
                it.printStackTrace()
            }
        }
    }
}

enum class HomeTab {
    MAIN,
    PREFERENCE
}
