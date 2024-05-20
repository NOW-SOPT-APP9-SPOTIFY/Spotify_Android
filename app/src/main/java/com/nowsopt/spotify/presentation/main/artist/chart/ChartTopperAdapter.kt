package com.nowsopt.spotify.presentation.main.artist.chart

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.nowsopt.spotify.databinding.ItemChartTopperBinding
import com.nowsopt.spotify.util.ItemDiffCallback

class ChartTopperAdapter(
    context: Context
) : ListAdapter<ChartTopperModel, ChartTopperViewHolder>(
    ItemDiffCallback<ChartTopperModel>(
        onContentsTheSame = { old, new -> old == new },
        onItemsTheSame = { old, new -> old == new }
    )
) {
    private val inflater by lazy { LayoutInflater.from(context) }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ChartTopperViewHolder =
        ChartTopperViewHolder(
            binding = ItemChartTopperBinding.inflate(inflater, parent, false)
        )

    override fun onBindViewHolder(holder: ChartTopperViewHolder, position: Int) {
        holder.onBind(currentList[position])
    }

    override fun getItemCount(): Int = currentList.size
}