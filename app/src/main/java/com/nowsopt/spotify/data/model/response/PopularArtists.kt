package com.nowsopt.spotify.data.model.response

import com.nowsopt.spotify.presentation.main.home.main.HomeMainModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PopularArtists(
    @SerialName("popularArtists")
    val popularArtists: List<PopularArtist>
) {
    @Serializable
    data class PopularArtist(
        @SerialName("id")
        val id: Int,
        @SerialName("artistName")
        val artistName: String
    )
}