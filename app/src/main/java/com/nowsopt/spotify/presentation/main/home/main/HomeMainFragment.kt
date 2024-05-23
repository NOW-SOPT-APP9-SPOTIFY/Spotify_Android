package com.nowsopt.spotify.presentation.main.home.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.nowsopt.spotify.databinding.FragmentHomeMainBinding
import com.nowsopt.spotify.util.base.BindingFragment

class HomeMainFragment : BindingFragment<FragmentHomeMainBinding>() {

    private val homeMainViewModel by viewModels<HomeMainViewModel>()

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): FragmentHomeMainBinding = FragmentHomeMainBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recommendMixAdapter = HomeMainAdapter()
        recommendMixAdapter.setItems(HomeMainAdapter.TYPE_RECOMMEND_MIX, homeMainViewModel.recommendMix)
        binding.rvHomeMainRecommendMix.run {
            adapter = recommendMixAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }

        val todayHitSongAdapter = HomeMainAdapter()
        todayHitSongAdapter.setItems(HomeMainAdapter.TYPE_TODAY_HIT_SONG, homeMainViewModel.todayHitSong)
        binding.rvHomeMainTodayHitSong.run {
            adapter = todayHitSongAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }

        val popularArtistAdapter = HomeMainAdapter()
        popularArtistAdapter.setItems(HomeMainAdapter.TYPE_POPULAR_ARTIST, homeMainViewModel.popularArtist)
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





