package com.okproject.musicexplorer.data.network.response.search

import com.okproject.musicexplorer.data.network.response.album.SimplifiedAlbumJson
import com.okproject.musicexplorer.data.network.response.content.ArtistJson
import com.okproject.musicexplorer.data.network.response.common.PagedList
import com.okproject.musicexplorer.data.network.response.playlist.SimplifiedPlaylistJson
import com.okproject.musicexplorer.data.network.response.content.TrackJson
import kotlinx.serialization.Serializable

@Serializable
data class SearchResultJson(
    val tracks: PagedList<TrackJson?>? = null,
    val artists: PagedList<ArtistJson?>? = null,
    val albums: PagedList<SimplifiedAlbumJson?>? = null,
    val playlists: PagedList<SimplifiedPlaylistJson?>? = null
)
