package com.nowsopt.spotify.presentation.main.artist.chart

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.nowsopt.spotify.R
import com.nowsopt.spotify.databinding.ItemChartTopperBinding
import java.text.DecimalFormat

class ChartTopperViewHolder(
    private val binding: ItemChartTopperBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(data: Songs.Song, position: Int) {
        with(binding) {
            tvNumber.text = (position + 1).toString()
            tvTitle.text = data.title
            tvLike.text = DecimalFormat("#,###").format(data.listenedCount)
            ivChartTopper.load(R.drawable.img_bruno)
        }
    }
}