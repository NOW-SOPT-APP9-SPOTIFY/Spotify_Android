package com.nowsopt.spotify.presentation.main.home.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.nowsopt.spotify.databinding.FragmentHomeMainBinding
import com.nowsopt.spotify.util.base.BindingFragment
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class HomeMainFragment : BindingFragment<FragmentHomeMainBinding>() {

    private val homeMainViewModel by viewModels<HomeMainViewModel>()
    private lateinit var recommendMixData: List<HomeMainModel.RecommendMix>
    private lateinit var todayHitSongData: List<HomeMainModel.TodayHitSong>
    private lateinit var popularArtistData: List<HomeMainModel.PopularArtist>

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): FragmentHomeMainBinding = FragmentHomeMainBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeMainViewModel.getPlaylists()
        homeMainViewModel.getHitSongs()
        homeMainViewModel.getPopularArtists()

        val recommendMixAdapter = HomeMainAdapter()
        homeMainViewModel.recommendMix.flowWithLifecycle(lifecycle).onEach { newData ->
            recommendMixData = newData.map { it.toRecommendMix() }
            recommendMixAdapter.setItems(HomeMainAdapter.TYPE_RECOMMEND_MIX, recommendMixData)
        }.launchIn(lifecycleScope)
        binding.rvHomeMainRecommendMix.run {
            adapter = recommendMixAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }

        val todayHitSongAdapter = HomeMainAdapter()
        homeMainViewModel.hitSong.flowWithLifecycle(lifecycle).onEach { newData ->
            todayHitSongData = newData.map { it.toTodayHitSong() }
            todayHitSongAdapter.setItems(HomeMainAdapter.TYPE_TODAY_HIT_SONG, todayHitSongData)
        }.launchIn(lifecycleScope)
        binding.rvHomeMainTodayHitSong.run {
            adapter = todayHitSongAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }

        val popularArtistAdapter = HomeMainAdapter()
        homeMainViewModel.popularArtist.flowWithLifecycle(lifecycle).onEach { newData ->
            popularArtistData = newData.map { it.toPopularArtist() }
            popularArtistAdapter.setItems(HomeMainAdapter.TYPE_POPULAR_ARTIST, popularArtistData)
        }.launchIn(lifecycleScope)
        binding.rvHomeMainPopularArtist.run {
            adapter = popularArtistAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }

        val recentPlayAdapter = HomeMainAdapter()
        recentPlayAdapter.setItems(HomeMainAdapter.TYPE_RECENT_PLAY, homeMainViewModel.recentPlay)
        binding.rvHomeMainRecentPlay.run {
            adapter = recentPlayAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }

        val listenableShowAdapter = HomeMainAdapter()
        listenableShowAdapter.setItems(HomeMainAdapter.TYPE_LISTENABLE_SHOW, homeMainViewModel.listenableShow)
        binding.rvHomeMainListenableShow.run {
            adapter = listenableShowAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }

        val popularRadioAdapter = HomeMainAdapter()
        popularRadioAdapter.setItems(HomeMainAdapter.TYPE_POPULAR_RADIO, homeMainViewModel.popularRadio)
        binding.rvHomeMainPopularRadio.run {
            adapter = popularRadioAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }
    }
}





