package com.nowsopt.spotify.presentation.main.artist.chart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.nowsopt.spotify.databinding.FragmentChartTopperBinding
import com.nowsopt.spotify.presentation.main.artist.model.Song
import com.nowsopt.spotify.util.base.BindingFragment
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach


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
        getChartTopper()
        observeChartTopper()
        backButtonClickListener()
    }

    private fun getChartTopper() = chartTopperViewModel.getChartTopper(1)

    private fun observeChartTopper() {
        chartTopperViewModel.chartTopperSong.flowWithLifecycle(lifecycle).onEach { song ->
            submitChartTopperList(song)
        }.launchIn(lifecycleScope)
    }

    private fun initBinds() {
        chartTopperAdapter = ChartTopperAdapter(requireContext())
        binding.rvChartTopper.adapter = chartTopperAdapter
    }

    private fun submitChartTopperList(data: List<Song>) = chartTopperAdapter.submitList(data)

    private fun backButtonClickListener() {
        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}
