package com.nowsopt.spotify.presentation.main.artist.chart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nowsopt.spotify.data.ServicePool.artistService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ChartTopperViewModel : ViewModel() {
    private val _chartTopperSong = MutableStateFlow<List<Songs.Song>>(emptyList())
    val chartTopperSong: StateFlow<List<Songs.Song>> get() = _chartTopperSong

    fun getChartTopper(artistId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                artistService.getChartTopper(artistId)
            }.onSuccess { songs ->
                songs.body()?.data?.songs?.let { song ->
                    _chartTopperSong.value = song
                }
            }.onFailure {
                it.printStackTrace()
            }
        }
    }

}
