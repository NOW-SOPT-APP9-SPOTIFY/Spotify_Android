package com.nowsopt.spotify.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Playlists (
    @SerialName("playlist")
    val playlists: List<Playlist>,
) {
    @Serializable
    data class Playlist(
        @SerialName("id")
        val id: Int,
        @SerialName("playlistName")
        val playlistName: Int,
        @SerialName("artists")
        val artists: List<String>
    )
}