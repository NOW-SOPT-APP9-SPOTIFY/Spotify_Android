package com.nowsopt.spotify.presentation.main.artist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.nowsopt.spotify.R
import com.nowsopt.spotify.databinding.FragmentArtistBinding
import com.nowsopt.spotify.presentation.main.artist.ArtistDataType.Companion.ALBUM
import com.nowsopt.spotify.presentation.main.artist.ArtistDataType.Companion.GENRE
import com.nowsopt.spotify.presentation.main.artist.ArtistDataType.Companion.INCLUDED
import com.nowsopt.spotify.presentation.main.artist.ArtistDataType.Companion.OTHER
import com.nowsopt.spotify.presentation.main.artist.ArtistDataType.Companion.PLAYLIST
import com.nowsopt.spotify.presentation.main.artist.ArtistDataType.Companion.POPULAR_MUSIC
import com.nowsopt.spotify.presentation.main.artist.model.ArtistModel
import com.nowsopt.spotify.util.base.BindingFragment
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class ArtistFragment : BindingFragment<FragmentArtistBinding>() {

    private lateinit var artistDetailAdapter: ArtistDetailAdapter
    private lateinit var popularAlbumAdapter: ArtistAdapter
    private lateinit var artistGenreAdapter: ArtistAdapter
    private lateinit var playlistAdapter: ArtistAdapter
    private lateinit var otherMusicAdapter: ArtistAdapter
    private lateinit var includedMusicAdapter: ArtistAdapter

    private val artistViewModel by viewModels<ArtistViewModel>()

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentArtistBinding = FragmentArtistBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initBinds()
        getArtistDetail()
        observeArtistDetail()
        chartTopperArrowButtonClickListener()
    }

    private fun initBinds() {
        initArtistDetailBinds()
        initPopularAlbumBinds()
        initArtistGenreBinds()
        initPlaylistBinds()
        initOtherMusicBinds()
        initIncludedMusicBinds()
        connectAdapter()
    }

    private fun getArtistDetail() = artistViewModel.getArtistDetail(1)

    private fun observeArtistDetail() {
        artistViewModel.detail.flowWithLifecycle(lifecycle).onEach { data ->
            data?.artistName?.let { showArtistDetail(it) }
            artistDetailAdapter.submitList(data?.songs)
        }.launchIn(lifecycleScope)
    }

    private fun showArtistDetail(artistName: String) {
        binding.tvArtist.text = artistName
    }

    private fun initArtistDetailBinds() {
        artistDetailAdapter = ArtistDetailAdapter(requireContext())
    }

    private fun initPopularAlbumBinds() {
        popularAlbumAdapter = initAdapter()
        submitData(ALBUM, artistViewModel.popularAlbumData)
    }

    private fun initArtistGenreBinds() {
        artistGenreAdapter = initAdapter()
        submitData(GENRE, artistViewModel.genreData)
    }

    private fun initPlaylistBinds() {
        playlistAdapter = initAdapter()
        submitData(PLAYLIST, artistViewModel.playlistData)
    }

    private fun initOtherMusicBinds() {
        otherMusicAdapter = initAdapter()
        submitData(OTHER, artistViewModel.otherMusicData)
    }

    private fun initIncludedMusicBinds() {
        includedMusicAdapter = initAdapter()
        submitData(INCLUDED, artistViewModel.includedMusicData)
    }

    private fun initAdapter(): ArtistAdapter  = ArtistAdapter(requireContext())

    private fun submitData(dataType: Int, data: List<ArtistModel>) {
        when(dataType) {
            INCLUDED -> includedMusicAdapter.submitList(data)
            OTHER -> otherMusicAdapter.submitList(data)
            PLAYLIST -> playlistAdapter.submitList(data)
            GENRE -> artistGenreAdapter.submitList(data)
            else -> popularAlbumAdapter.submitList(data)
        }
    }

    private fun connectAdapter() {
        with(binding) {
            rvPopularMusic.adapter = artistDetailAdapter
            rvPopularAlbum.adapter = popularAlbumAdapter
            tvGenreTitle.text = "Bruno Mars 장르"
            rvArtistGenre.adapter = artistGenreAdapter
            rvArtistPlaylist.adapter = playlistAdapter
            rvOtherMusic.adapter = otherMusicAdapter
            rvIncludedMusic.adapter = includedMusicAdapter
        }
    }

    private fun chartTopperArrowButtonClickListener() {
        binding.btnChartTopperArrow.setOnClickListener {
            findNavController().navigate(R.id.action_artist_fragment_to_chartTopperFragment)
        }
    }
}