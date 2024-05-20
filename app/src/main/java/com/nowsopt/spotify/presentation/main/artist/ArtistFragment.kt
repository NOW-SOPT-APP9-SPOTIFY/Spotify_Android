package com.nowsopt.spotify.presentation.main.artist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import com.nowsopt.spotify.databinding.FragmentArtistBinding
import com.nowsopt.spotify.presentation.main.artist.ArtistDataType.Companion.ALBUM
import com.nowsopt.spotify.presentation.main.artist.ArtistDataType.Companion.GENRE
import com.nowsopt.spotify.presentation.main.artist.ArtistDataType.Companion.INCLUDED
import com.nowsopt.spotify.presentation.main.artist.ArtistDataType.Companion.OTHER
import com.nowsopt.spotify.presentation.main.artist.ArtistDataType.Companion.PLAYLIST
import com.nowsopt.spotify.presentation.main.artist.ArtistDataType.Companion.POPULAR_MUSIC
import com.nowsopt.spotify.presentation.main.artist.ArtistModel.MockArtistGenreModel
import com.nowsopt.spotify.presentation.main.artist.ArtistModel.MockIncludedMusic
import com.nowsopt.spotify.presentation.main.artist.ArtistModel.MockOtherMusic
import com.nowsopt.spotify.presentation.main.artist.ArtistModel.MockPlaylistModel
import com.nowsopt.spotify.presentation.main.artist.ArtistModel.MockPopularAlbumModel
import com.nowsopt.spotify.presentation.main.artist.ArtistModel.MockPopularMusicModel
import com.nowsopt.spotify.util.base.BindingActivity
import com.nowsopt.spotify.util.base.BindingFragment

class ArtistFragment : BindingFragment<FragmentArtistBinding>() {

    private lateinit var popularMusicAdapter: ArtistAdapter
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initBinds()
    }

    private fun initBinds() {
        initPopularMusicBinds()
        initPopularAlbumBinds()
        initArtistGenreBinds()
        initPlaylistBinds()
        initOtherMusicBinds()
        initIncludedMusicBinds()
        connectAdapter()
    }

    private fun initPopularMusicBinds() {
        popularMusicAdapter = initAdapter()
        submitData(POPULAR_MUSIC, artistViewModel.popularMusicData)
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
            ALBUM -> popularAlbumAdapter.submitList(data)
            POPULAR_MUSIC -> popularMusicAdapter.submitList(data)
        }
    }

    private fun connectAdapter() {
        with(binding) {
            rvPopularMusic.adapter = popularMusicAdapter
            rvPopularAlbum.adapter = popularAlbumAdapter
            tvGenreTitle.text = "Bruno Mars 장르"
            rvArtistGenre.adapter = artistGenreAdapter
            rvArtistPlaylist.adapter = playlistAdapter
            rvOtherMusic.adapter = otherMusicAdapter
            rvIncludedMusic.adapter = includedMusicAdapter
        }
    }
}