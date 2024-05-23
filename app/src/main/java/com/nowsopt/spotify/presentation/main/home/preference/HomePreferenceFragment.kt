package com.nowsopt.spotify.presentation.main.home.preference

import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import coil.load
import coil.transform.CircleCropTransformation
import com.nowsopt.spotify.R
import com.nowsopt.spotify.data.model.response.Albums
import com.nowsopt.spotify.databinding.FragmentHomePreferenceBinding
import com.nowsopt.spotify.presentation.main.home.HomeViewModel
import com.nowsopt.spotify.util.base.BindingFragment
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class HomePreferenceFragment : BindingFragment<FragmentHomePreferenceBinding>() {
    private lateinit var homePreferenceMusicAdapter: HomePreferenceMusicAdapter
    private val homeViewModel: HomeViewModel by viewModels()

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): FragmentHomePreferenceBinding =
        FragmentHomePreferenceBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initBinds()
        getAlbums()
        observeRecommendAlbums()
    }

    private fun initBinds() {
        homePreferenceMusicAdapter =
            HomePreferenceMusicAdapter(requireContext()) { mockMusicModel ->
                // 클릭시 화면 이동 로직 구현 -> 블러 화면
                findNavController().navigate(R.id.action_home_navigation_to_musicDetailFragment)
            }

        with(binding) {
            ivHomePreferenceProfile.load(R.drawable.img_profile_23) {
                transformations(CircleCropTransformation())
            }

            // 서버에서 유저 이름을 준다면 활용할 예정
            val spannableString = SpannableString(tvHomePreferenceProfileName.text)
            spannableString.setSpan(
                StyleSpan(Typeface.BOLD),
                0,
                12,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            tvHomePreferenceProfileName.text = spannableString

            rvHomePreference.adapter = homePreferenceMusicAdapter
        }
    }

    private fun getAlbums() {
        homeViewModel.getAlbums()
    }

    private fun observeRecommendAlbums() {
        homeViewModel.recommendAlbums.flowWithLifecycle(lifecycle).onEach { album ->
            submitList(album)
        }.launchIn(lifecycleScope)
    }

    private fun submitList(list: List<Albums.Album>) {
        homePreferenceMusicAdapter.submitList(list)
    }
}
