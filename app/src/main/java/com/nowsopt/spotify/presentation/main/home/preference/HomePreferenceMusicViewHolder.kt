package com.nowsopt.spotify.presentation.main.home.preference

import android.graphics.drawable.GradientDrawable
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.nowsopt.spotify.R
import com.nowsopt.spotify.data.model.response.Albums
import com.nowsopt.spotify.databinding.ItemHomePreferenceMusicBinding

class HomePreferenceMusicViewHolder(
    private val binding: ItemHomePreferenceMusicBinding,
    private val onClick: (Albums.Album) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(album: Albums.Album) {
        with(binding) {
            cvHomePreferenceMusic.setOnClickListener {
                onClick(album)
            }
            Log.e("TAG", "onBind: ${"${album.artist.artistName} - ${album.firstSongName}"}", )
            tvHomePreferenceMusicTitle.text = "${album.artist.artistName} - ${album.firstSongName}"
            tvHomePreferenceMusicAlbumMini.text = "앨범 · " + album.artist.artistName
            tvHomePreferenceMusicTitleMini.text = album.albumName

            // 리소스 색상 값 가져오기 -> 추후 enum과 when을 활용한 방법으로 수정 예정.
            val startColor = ContextCompat.getColor(itemView.context, R.color.gradi_m1_start)
            val centerColor = ContextCompat.getColor(itemView.context, R.color.gradi_m1_center)
            val endColor = ContextCompat.getColor(itemView.context, R.color.gradi_m1_end)

            val gradientDrawable = GradientDrawable(
                GradientDrawable.Orientation.TOP_BOTTOM,
                intArrayOf(startColor, centerColor, endColor)
            )

            clHomePreferenceMusic.background = gradientDrawable
        }
    }
}
