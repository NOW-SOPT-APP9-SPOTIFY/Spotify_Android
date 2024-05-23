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
                imageUrl = R.drawable.img_today_hit_song_1,
                title= this.title,
                artist=this.artist)
        }
    }
}