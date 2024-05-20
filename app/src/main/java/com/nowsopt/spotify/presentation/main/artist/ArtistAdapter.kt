package com.nowsopt.spotify.presentation.main.artist

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.nowsopt.spotify.databinding.ItemArtistGenreBinding
import com.nowsopt.spotify.databinding.ItemArtistPlaylistBinding
import com.nowsopt.spotify.databinding.ItemIncludedMusicBinding
import com.nowsopt.spotify.databinding.ItemOtherMusicBinding
import com.nowsopt.spotify.databinding.ItemPopularAlbumBinding
import com.nowsopt.spotify.databinding.ItemPopularMusicBinding
import com.nowsopt.spotify.presentation.main.artist.ArtistModel.MockArtistGenreModel
import com.nowsopt.spotify.presentation.main.artist.ArtistModel.MockIncludedMusic
import com.nowsopt.spotify.presentation.main.artist.ArtistModel.MockOtherMusic
import com.nowsopt.spotify.presentation.main.artist.ArtistModel.MockPlaylistModel
import com.nowsopt.spotify.presentation.main.artist.ArtistModel.MockPopularAlbumModel
import com.nowsopt.spotify.presentation.main.artist.ArtistModel.MockPopularMusicModel
import com.nowsopt.spotify.presentation.main.artist.album.PopularAlbumViewHolder
import com.nowsopt.spotify.presentation.main.artist.genre.ArtistGenreViewHolder
import com.nowsopt.spotify.presentation.main.artist.included.IncludedMusicViewHolder
import com.nowsopt.spotify.presentation.main.artist.other.OtherMusicViewHolder
import com.nowsopt.spotify.presentation.main.artist.playlist.PlaylistViewHolder
import com.nowsopt.spotify.presentation.main.artist.popular.PopularMusicViewHolder
import com.nowsopt.spotify.util.ItemDiffCallback

class ArtistAdapter(
    context: Context
) : ListAdapter<ArtistModel, ViewHolder>(
    ItemDiffCallback<ArtistModel>(
        onContentsTheSame = { old, new -> old == new },
        onItemsTheSame = { old, new -> old == new }
    )
) {
    private val inflater by lazy { LayoutInflater.from(context) }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (viewType) {
            ALBUM -> PopularAlbumViewHolder(ItemPopularAlbumBinding.inflate(inflater, parent, false))
            GENRE -> ArtistGenreViewHolder(ItemArtistGenreBinding.inflate(inflater, parent, false))
            INCLUDED -> IncludedMusicViewHolder(ItemIncludedMusicBinding.inflate(inflater, parent, false))
            OTHER -> OtherMusicViewHolder(ItemOtherMusicBinding.inflate(inflater, parent, false))
            PLAYLIST -> PlaylistViewHolder(ItemArtistPlaylistBinding.inflate(inflater, parent, false))
            else -> PopularMusicViewHolder(ItemPopularMusicBinding.inflate(inflater, parent, false))
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)

        when(getItemViewType(position)) {
            ALBUM -> (holder as PopularAlbumViewHolder).onBind(item as MockPopularAlbumModel)
            GENRE -> (holder as ArtistGenreViewHolder).onBind(item as MockArtistGenreModel)
            INCLUDED -> (holder as IncludedMusicViewHolder).onBind(item as MockIncludedMusic)
            OTHER -> (holder as OtherMusicViewHolder).onBind(item as MockOtherMusic)
            PLAYLIST -> (holder as PlaylistViewHolder).onBind(item as MockPlaylistModel)
            else -> (holder as PopularMusicViewHolder).onBind(item as MockPopularMusicModel)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when(getItem(position)) {
            is MockPopularAlbumModel -> ALBUM
            is MockArtistGenreModel -> GENRE
            is MockIncludedMusic -> INCLUDED
            is MockOtherMusic -> OTHER
            is MockPlaylistModel -> PLAYLIST
            else -> POPULAR_MUSIC
        }
    }

    companion object {
        private const val ALBUM = 0
        private const val GENRE = 1
        private const val INCLUDED = 2
        private const val OTHER = 3
        private const val PLAYLIST = 4
        private const val POPULAR_MUSIC = 5
    }
}