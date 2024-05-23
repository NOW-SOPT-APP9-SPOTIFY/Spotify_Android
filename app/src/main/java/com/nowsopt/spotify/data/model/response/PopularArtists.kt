package com.nowsopt.spotify.data.model.response

import com.nowsopt.spotify.R
import com.nowsopt.spotify.presentation.main.home.main.HomeMainModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PopularArtists(
    @SerialName("artists")
    val popularArtists: List<PopularArtist>
) {
    @Serializable
    data class PopularArtist(
        @SerialName("id")
        val id: Int,
        @SerialName("artistName")
        val artistName: String
    ) {
        fun toPopularArtist(): HomeMainModel.PopularArtist {
            return HomeMainModel.PopularArtist(
                imageUrl = R.drawable.img_popular_artist_3,
                artist = this.artistName
            )
        }
    }
}