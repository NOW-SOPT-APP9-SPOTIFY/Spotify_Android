package com.nowsopt.spotify.presentation.main.home.preference

import android.graphics.drawable.GradientDrawable
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import coil.load
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
            val (image, start, center, end) = when (album.id) {
                1 -> Quadruple(
                    R.drawable.img_bruno,
                    R.color.gradi_m1_start,
                    R.color.gradi_m1_center,
                    R.color.gradi_m1_end
                )

                6 -> Quadruple(
                    R.drawable.img_the_script,
                    R.color.gradi_m2_start,
                    R.color.gradi_m2_center,
                    R.color.gradi_m2_end
                )

                else -> Quadruple(
                    R.drawable.img_xxanteria,
                    R.color.gradi_m3_start,
                    R.color.gradi_m3_center,
                    R.color.gradi_m3_end
                )
            }

            ivHomePreferenceMusicAlbum.load(image)
            ivHomePreferenceMusicAlbumMini.load(image)
            tvHomePreferenceMusicTitle.text = "${album.artist.artistName} - ${album.firstSongName}"
            tvHomePreferenceMusicAlbumMini.text = "앨범 · " + album.artist.artistName
            tvHomePreferenceMusicTitleMini.text = album.albumName

            val startColor = ContextCompat.getColor(itemView.context, start)
            val centerColor = ContextCompat.getColor(itemView.context, center)
            val endColor = ContextCompat.getColor(itemView.context, end)

            val gradientDrawable = GradientDrawable(
                GradientDrawable.Orientation.TOP_BOTTOM,
                intArrayOf(startColor, centerColor, endColor)
            )

            clHomePreferenceMusic.background = gradientDrawable
        }
    }

    data class Quadruple<A, B, C, D>(val first: A, val second: B, val third: C, val fourth: D)
}
