package com.nowsopt.spotify.presentation.main.home.preference

import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import coil.load
import coil.transform.CircleCropTransformation
import com.nowsopt.spotify.R
import com.nowsopt.spotify.databinding.FragmentHomePreferenceBinding
import com.nowsopt.spotify.util.base.BindingFragment

class HomePreferenceFragment : BindingFragment<FragmentHomePreferenceBinding>() {
    private lateinit var homePreferenceMusicAdapter: HomePreferenceMusicAdapter

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
    ): FragmentHomePreferenceBinding =
        FragmentHomePreferenceBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initBinds()
    }

    private fun initBinds() {
        homePreferenceMusicAdapter =
            HomePreferenceMusicAdapter(requireContext()) { mockMusicModel ->
                // 클릭시 화면 이동 로직 구현 -> 블러 화면
                findNavController().navigate(R.id.action_home_navigation_to_musicDetailFragment)
            }

        // 추후 서버에서 값 받아온 처리 전 일단 임시로 넣어둠
        homePreferenceMusicAdapter.submitList(
            listOf(
                MockMusicModel(
                    title = "title1",
                    artist = "artist",
                    album = "album",
                    imageUrl = "imageUrl",
                    isBookmark = false
                ),
                MockMusicModel(
                    title = "title2",
                    artist = "artist",
                    album = "album",
                    imageUrl = "imageUrl",
                    isBookmark = false
                ),
                MockMusicModel(
                    title = "title3",
                    artist = "artist",
                    album = "album",
                    imageUrl = "imageUrl",
                    isBookmark = false
                ),
            )
        )

        // 임시 이미지 넣음
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
}
