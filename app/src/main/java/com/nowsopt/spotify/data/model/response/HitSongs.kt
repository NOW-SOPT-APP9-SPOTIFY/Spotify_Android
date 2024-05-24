package com.nowsopt.spotify.data.model.response

import com.nowsopt.spotify.R
import com.nowsopt.spotify.presentation.main.home.main.HomeMainModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HitSongs (
    @SerialName("songs")
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
    ) {
        fun toTodayHitSong(): HomeMainModel.TodayHitSong {
            return HomeMainModel.TodayHitSong(
                imageUrl = getImageUrl(this.id),
                title= this.title,
                artist=this.artist)
        }

        private fun getImageUrl(id: Int): Int {
            return when(id) {
                1,3 -> R.drawable.img_today_hit_song_1
                2,5,7,9,25 -> R.drawable.img_today_hit_song_2
                4,8 -> R.drawable.img_today_hit_song_4
                34 -> R.drawable.img_today_hit_song_34
                35 -> R.drawable.img_today_hit_song_35
                36 -> R.drawable.img_today_hit_song_36
                6 -> R.drawable.img_today_hit_song_6
                else -> R.drawable.img_today_hit_song_1
            }
        }
    }
}