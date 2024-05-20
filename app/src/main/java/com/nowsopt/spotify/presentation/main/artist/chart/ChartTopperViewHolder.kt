package com.nowsopt.spotify.presentation.main.artist.chart

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.nowsopt.spotify.R
import com.nowsopt.spotify.databinding.ItemChartTopperBinding
import java.text.DecimalFormat

class ChartTopperViewHolder(
    private val binding: ItemChartTopperBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(chartTopperModel: ChartTopperModel) {
        with(binding) {
            tvNumber.text = chartTopperModel.number.toString()
            tvTitle.text = chartTopperModel.title
            tvLike.text = DecimalFormat("#,###").format(chartTopperModel.like)
            ivChartTopper.load(R.drawable.img_bruno)
        }
    }
}