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
import com.nowsopt.spotify.presentation.main.artist.model.ArtistModel
import com.nowsopt.spotify.presentation.main.artist.model.ArtistModel.MockArtistGenreModel
import com.nowsopt.spotify.presentation.main.artist.model.ArtistModel.MockIncludedMusic
import com.nowsopt.spotify.presentation.main.artist.model.ArtistModel.MockOtherMusic
import com.nowsopt.spotify.presentation.main.artist.model.ArtistModel.MockPlaylistModel
import com.nowsopt.spotify.presentation.main.artist.model.ArtistModel.MockPopularAlbumModel
import com.nowsopt.spotify.presentation.main.artist.viewholder.ArtistGenreViewHolder
import com.nowsopt.spotify.presentation.main.artist.viewholder.IncludedMusicViewHolder
import com.nowsopt.spotify.presentation.main.artist.viewholder.OtherMusicViewHolder
import com.nowsopt.spotify.presentation.main.artist.viewholder.PlaylistViewHolder
import com.nowsopt.spotify.presentation.main.artist.viewholder.PopularAlbumViewHolder
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
            ArtistDataType.ALBUM.ordinal -> PopularAlbumViewHolder(ItemPopularAlbumBinding.inflate(inflater, parent, false))
            ArtistDataType.GENRE.ordinal -> ArtistGenreViewHolder(ItemArtistGenreBinding.inflate(inflater, parent, false))
            ArtistDataType.INCLUDED.ordinal-> IncludedMusicViewHolder(ItemIncludedMusicBinding.inflate(inflater, parent, false))
            ArtistDataType.OTHER.ordinal -> OtherMusicViewHolder(ItemOtherMusicBinding.inflate(inflater, parent, false))
            else -> PlaylistViewHolder(ItemArtistPlaylistBinding.inflate(inflater, parent, false))
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)

        when(getItemViewType(position)) {
            ArtistDataType.ALBUM.ordinal -> (holder as PopularAlbumViewHolder).onBind(item as MockPopularAlbumModel)
            ArtistDataType.GENRE.ordinal -> (holder as ArtistGenreViewHolder).onBind(item as MockArtistGenreModel)
            ArtistDataType.INCLUDED.ordinal -> (holder as IncludedMusicViewHolder).onBind(item as MockIncludedMusic)
            ArtistDataType.OTHER.ordinal -> (holder as OtherMusicViewHolder).onBind(item as MockOtherMusic)
            else -> (holder as PlaylistViewHolder).onBind(item as MockPlaylistModel)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when(getItem(position)) {
            is MockPopularAlbumModel -> ArtistDataType.ALBUM.ordinal
            is MockArtistGenreModel -> ArtistDataType.GENRE.ordinal
            is MockIncludedMusic -> ArtistDataType.INCLUDED.ordinal
            is MockOtherMusic -> ArtistDataType.OTHER.ordinal
            else -> ArtistDataType.PLAYLIST.ordinal
        }
    }
}
