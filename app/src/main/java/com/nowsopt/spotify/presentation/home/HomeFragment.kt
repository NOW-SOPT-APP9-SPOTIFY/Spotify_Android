package com.nowsopt.spotify.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.chip.Chip
import com.nowsopt.spotify.R
import com.nowsopt.spotify.databinding.FragmentHomeBinding
import com.nowsopt.spotify.util.base.BindingFragment

class HomeFragment : BindingFragment<FragmentHomeBinding>() {
    private lateinit var fragmentStateAdapter: FragmentStateAdapter
    private lateinit var fragmentList: ArrayList<Fragment>
    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): FragmentHomeBinding = FragmentHomeBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFragmentStateAdapter()
        setOnChipClickListener()
    }

    private fun setFragmentStateAdapter() {
        fragmentList = ArrayList()
        fragmentList.apply {
            add(HomeMainFragment())
            add(HomePreferenceFragment())
        }

        fragmentStateAdapter = FragmentStateAdapter(fragmentList, requireActivity())

        with(binding.viewPager) {
            adapter = fragmentStateAdapter
            isUserInputEnabled = false
        }
    }

    private fun setOnChipClickListener() {
        with(binding) {
            chipCh.setOnClickListener {
                toggleChipVisibility(
                    showChips = listOf(chipCh, chipX),
                    hideChips = listOf(chipPodcast, chipHeart),
                    duration = 300
                )
                setSelectedChipColorChanger(chipCh, R.color.green, R.color.gray40)

                viewPager.setCurrentItem(1, false)
            }

            chipX.setOnClickListener {
                toggleChipVisibility(
                    showChips = listOf(chipCh, chipPodcast, chipHeart),
                    hideChips = listOf(chipX),
                    duration = 300
                )
                setSelectedChipColorChanger(chipCh, R.color.gray40, R.color.white)

                viewPager.setCurrentItem(0, false)
            }
        }
    }

    private fun toggleChipVisibility(showChips: List<Chip>, hideChips: List<Chip>, duration: Long) {
        hideChips.forEach { it.isVisible = false }
        showChips.forEach { chip ->
            chip.apply {
                visibility = View.VISIBLE
                alpha = 0f
                animate().alpha(1f).setDuration(duration).start()
            }
        }
    }

    private fun setSelectedChipColorChanger(
        chip: Chip,
        @ColorRes backGroundColor: Int,
        @ColorRes textColor: Int,
    ) {
        chip.setChipBackgroundColorResource(backGroundColor)
        chip.setTextColor(ContextCompat.getColor(requireContext(), textColor))
    }
}

class FragmentStateAdapter(
    private val fragmentList: ArrayList<Fragment>,
    fragmentActivity: FragmentActivity,
) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = fragmentList.size
    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }
}
