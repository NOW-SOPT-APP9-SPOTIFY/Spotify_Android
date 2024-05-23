package com.nowsopt.spotify.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HitSongs (
    @SerialName("hitSongs")
    val hitSongs: List<HitSong>,
) {
    @Serializable
    data class HitSong(
        @SerialName("id")
        val id: Int,
        @SerialName("artist")
        val artist: String,
        @SerialName("title")
        val title: String
    )
}