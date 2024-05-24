package com.nowsopt.spotify.presentation.main.artist.chart

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.nowsopt.spotify.R
import com.nowsopt.spotify.databinding.ItemChartTopperBinding
import com.nowsopt.spotify.presentation.main.artist.model.Song
import java.text.DecimalFormat

class ChartTopperViewHolder(
    private val binding: ItemChartTopperBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(data: Song, position: Int) {
        with(binding) {
            tvNumber.text = (position + 1).toString()
            tvTitle.text = data.title
            tvLike.text = DecimalFormat("#,###").format(data.listenedCount)
            when(data.id) {
                1, 3 -> ivChartTopper.load(R.drawable.img_chart_songs_1_3)
                2, 5, 7, 9, 25 -> ivChartTopper.load(R.drawable.img_chart_songs_2_5_7_9_25)
                4, 8 -> ivChartTopper.load(R.drawable.img_chart_songs_4_8)
                else -> ivChartTopper.load(R.drawable.img_chart_songs_6) // 6
            }
        }
    }
}