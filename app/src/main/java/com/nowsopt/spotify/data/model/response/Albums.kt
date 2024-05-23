package com.nowsopt.spotify.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Albums(
    @SerialName("albums")
    val albums: List<Album>,
) {
    @Serializable
    data class Album(
        @SerialName("albumName")
        val albumName: String,
        @SerialName("artist")
        val artist: Artist,
        @SerialName("createdAt")
        val createdAt: String,
        @SerialName("firstSongName")
        val firstSongName: String,
        @SerialName("id")
        val id: Int,
    ) {
        @Serializable
        data class Artist(
            @SerialName("artistId")
            val artistId: Int,
            @SerialName("artistName")
            val artistName: String,
        )
    }
}
