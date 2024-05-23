package com.nowsopt.spotify.presentation.main.artist.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Songs(
    @SerialName("songs")
    val songs: List<Song>
)

@Serializable
data class Song(
    @SerialName("id")
    val id: Int,

    @SerialName("title")
    val title: String,

    @SerialName("listenedCount")
    val listenedCount: Int
)
