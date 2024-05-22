package com.nowsopt.spotify.presentation.main.artist.model

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArtistDetailResponse (
    @SerialName("id")
    val id: Int,

    @SerialName("artistName")
    val artistName: String,

    @SerialName("songs")
    val songs: List<Song>
)
