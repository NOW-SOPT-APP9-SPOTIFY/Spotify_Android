package com.nowsopt.spotify.presentation.main.artist.chart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.nowsopt.spotify.R
import com.nowsopt.spotify.databinding.FragmentChartTopperBinding
import com.nowsopt.spotify.util.base.BindingFragment


class ChartTopperFragment : BindingFragment<FragmentChartTopperBinding>() {
    private lateinit var chartTopperAdapter: ChartTopperAdapter

    private val chartTopperViewModel by viewModels<ChartTopperViewModel>()

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentChartTopperBinding = FragmentChartTopperBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initBinds()
        navigateToArtist()
    }

    private fun initBinds() {
        chartTopperAdapter = ChartTopperAdapter(requireContext())
        chartTopperAdapter.submitList(chartTopperViewModel.chartTopperData)
        binding.rvChartTopper.adapter = chartTopperAdapter
    }

    private fun navigateToArtist() {
        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }


}