package com.nowsopt.spotify.data.model.response

import com.nowsopt.spotify.R
import com.nowsopt.spotify.presentation.main.home.main.HomeMainModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Playlists (
    @SerialName("playlists")
    val playlists: List<Playlist>,
) {
    @Serializable
    data class Playlist(
        @SerialName("id")
        val id: Int,
        @SerialName("playlistName")
        val playlistName: String,
        @SerialName("artists")
        val artists: List<String>
    ) {
        fun toRecommendMix(): HomeMainModel.RecommendMix {
            return HomeMainModel.RecommendMix(
                imageUrl = R.drawable.img_recommend_mix_1,
                theme = this.playlistName,
                artists = this.artists)
        }
    }
}