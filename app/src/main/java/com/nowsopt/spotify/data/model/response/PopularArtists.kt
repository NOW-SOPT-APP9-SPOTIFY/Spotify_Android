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
                imageUrl = getImageUrl(this.id),
                artist = this.artistName
            )
        }

        private fun getImageUrl(id: Int): Int {
            return when(id) {
                2 -> R.drawable.img_popular_artist_2
                3 -> R.drawable.img_popular_artist_3
                6 -> R.drawable.img_popular_artist_6
                7 -> R.drawable.img_popular_artist_7
                12 -> R.drawable.img_popular_artist_12
                13 -> R.drawable.img_popular_artist_13
                else -> R.drawable.img_popular_artist_12
            }
        }
    }
}