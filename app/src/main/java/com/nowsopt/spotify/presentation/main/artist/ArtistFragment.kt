package com.nowsopt.spotify.presentation.main.artist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.nowsopt.spotify.databinding.FragmentArtistBinding
import com.nowsopt.spotify.presentation.main.artist.ArtistModel.MockArtistGenreModel
import com.nowsopt.spotify.presentation.main.artist.ArtistModel.MockIncludedMusic
import com.nowsopt.spotify.presentation.main.artist.ArtistModel.MockOtherMusic
import com.nowsopt.spotify.presentation.main.artist.ArtistModel.MockPlaylistModel
import com.nowsopt.spotify.presentation.main.artist.ArtistModel.MockPopularAlbumModel
import com.nowsopt.spotify.presentation.main.artist.ArtistModel.MockPopularMusicModel
import com.nowsopt.spotify.presentation.main.artist.album.PopularAlbumAdapter
import com.nowsopt.spotify.presentation.main.artist.genre.ArtistGenreAdapter
import com.nowsopt.spotify.presentation.main.artist.included.IncludedMusicAdapter
import com.nowsopt.spotify.presentation.main.artist.other.OtherMusicAdapter
import com.nowsopt.spotify.presentation.main.artist.playlist.PlaylistAdapter
import com.nowsopt.spotify.presentation.main.artist.popular.PopularMusicAdapter
import com.nowsopt.spotify.util.base.BindingFragment

class ArtistFragment : BindingFragment<FragmentArtistBinding>() {
    private lateinit var popularMusicAdapter: PopularMusicAdapter
    private lateinit var popularAlbumAdapter: PopularAlbumAdapter
    private lateinit var artistGenreAdapter: ArtistGenreAdapter
    private lateinit var playlistAdapter: PlaylistAdapter
    private lateinit var otherMusicAdapter: OtherMusicAdapter
    private lateinit var includedMusicAdapter: IncludedMusicAdapter

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
    }

    private fun initPopularMusicBinds() {
        popularMusicAdapter = PopularMusicAdapter(requireContext())

        popularMusicAdapter.submitList(
            listOf(
                MockPopularMusicModel(
                    number = 1,
                    imageUrl = "imageUrl",
                    title = "title1",
                    like = 2022950208
                ),
                MockPopularMusicModel(
                    number = 2,
                    imageUrl = "imageUrl",
                    title = "title2",
                    like = 2022950208
                ),
                MockPopularMusicModel(
                    number = 3,
                    imageUrl = "imageUrl",
                    title = "title3",
                    like = 2022950208
                ),
                MockPopularMusicModel(
                    number = 4,
                    imageUrl = "imageUrl",
                    title = "title4",
                    like = 2022950208
                )
            )
        )

        with(binding) {
            rvPopularMusic.adapter = popularMusicAdapter
        }
    }

    private fun initPopularAlbumBinds() {
        popularAlbumAdapter = PopularAlbumAdapter(requireContext())

        popularAlbumAdapter.submitList(
            listOf(
                MockPopularAlbumModel(
                    title = "title1",
                    release = 2012
                ),
                MockPopularAlbumModel(
                    title = "title2",
                    release = 2020
                ),
                MockPopularAlbumModel(
                    title = "title3",
                    release = 2014
                ),
                MockPopularAlbumModel(
                    title = "title4",
                    release = 2004
                ),
                MockPopularAlbumModel(
                    title = "title5",
                    release = 2010
                )
            )
        )

        with(binding) {
            rvPopularAlbum.adapter = popularAlbumAdapter
        }
    }

    private fun initArtistGenreBinds() {
        artistGenreAdapter = ArtistGenreAdapter(requireContext())

        artistGenreAdapter.submitList(
            listOf(
                MockArtistGenreModel(
                    imageUrl = "imageUrl",
                    title = "title1",
                    description = "This is Bruno Mars. 꼭 들어야 하는 트랙을 하나의 플레이리스트"
                ),
                MockArtistGenreModel(
                    imageUrl = "imageUrl",
                    title = "title2",
                    description = "This is Bruno Mars. 꼭 들어야 하는 트랙을 하나의 플레이리스트"
                ),
                MockArtistGenreModel(
                    imageUrl = "imageUrl",
                    title = "title3",
                    description = "This is Bruno Mars. 꼭 들어야 하는 트랙을 하나의 플레이리스트"
                ),
                MockArtistGenreModel(
                    imageUrl = "imageUrl",
                    title = "title4",
                    description = "This is Bruno Mars. 꼭 들어야 하는 트랙을 하나의 플레이리스트"
                )
            )
        )

        with(binding) {
            tvGenreTitle.text = "Bruno Mars 장르"
            rvArtistGenre.adapter = artistGenreAdapter
        }
    }

    private fun initPlaylistBinds() {
        playlistAdapter = PlaylistAdapter(requireContext())

        playlistAdapter.submitList(
            listOf(
                MockPlaylistModel(
                    imageUrl = "imageUrl",
                    title = "title1"
                ),
                MockPlaylistModel(
                    imageUrl = "imageUrl",
                    title = "title2"
                ),
                MockPlaylistModel(
                    imageUrl = "imageUrl",
                    title = "title3"
                )
            )
        )

        with(binding) {
            rvArtistPlaylist.adapter = playlistAdapter
        }
    }

    private fun initOtherMusicBinds() {
        otherMusicAdapter = OtherMusicAdapter(requireContext())

        otherMusicAdapter.submitList(
            listOf(
                MockOtherMusic(
                    imageUrl = "imageUrl",
                    name = "name1"
                ),
                MockOtherMusic(
                    imageUrl = "imageUrl",
                    name = "name2"
                ),
                MockOtherMusic(
                    imageUrl = "imageUrl",
                    name = "name3"
                )
            )
        )

        with(binding) {
            rvOtherMusic.adapter = otherMusicAdapter
        }
    }

    private fun initIncludedMusicBinds() {
        includedMusicAdapter = IncludedMusicAdapter(requireContext())

        includedMusicAdapter.submitList(
            listOf(
                MockIncludedMusic(
                    imageUrl = "imageUrl",
                    title = "title1",
                    release = 2012
                ),
                MockIncludedMusic(
                    imageUrl = "imageUrl",
                    title = "title2",
                    release = 2004
                ),
                MockIncludedMusic(
                    imageUrl = "imageUrl",
                    title = "title3",
                    release = 2024
                )
            )
        )

        with(binding) {
            rvIncludedMusic.adapter = includedMusicAdapter
        }
    }
}