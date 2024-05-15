package com.nowsopt.spotify.presentation.main.home.preference

import android.graphics.drawable.GradientDrawable
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.nowsopt.spotify.R
import com.nowsopt.spotify.databinding.ItemHomePreferenceMusicBinding

class HomePreferenceMusicViewHolder(
    private val binding: ItemHomePreferenceMusicBinding,
    private val onClick: (MockMusicModel) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(mockMusicModel: MockMusicModel) {
        with(binding) {
            tvHomePreferenceMusicTitle.text = mockMusicModel.title

            // 리소스 색상 값 가져오기 -> 추후 enum과 when을 활용한 방법으로 수정 예정.
            val startColor = ContextCompat.getColor(itemView.context, R.color.gradi_m1_start)
            val centerColor = ContextCompat.getColor(itemView.context, R.color.gradi_m1_center)
            val endColor = ContextCompat.getColor(itemView.context, R.color.gradi_m1_end)

            val gradientDrawable = GradientDrawable(
                GradientDrawable.Orientation.TOP_BOTTOM,
                intArrayOf(startColor, centerColor, endColor)
            )

            viewGradientBackground.background = gradientDrawable
        }
    }
}
