package com.okproject.musicexplorer.data.mapper

import com.okproject.musicexplorer.data.network.response.common.PagedList
import com.okproject.musicexplorer.data.network.response.playlist.SimplifiedPlaylistJson
import com.okproject.musicexplorer.domain.model.SimplifiedPlaylist
import timber.log.Timber

// TODO remove temporary logs
private const val MAPPER_TAG = "PlaylistMapper"
fun SimplifiedPlaylistJson.toSimplifiedPlaylist(): SimplifiedPlaylist {
    Timber.tag(MAPPER_TAG).d(this.toString())
    return SimplifiedPlaylist(
        id = this.id,
        name = this.name,
        description = this.description,
        image = this.images.firstOrNull()?.url ?: "",
        owner = this.owner.displayName,
        totalTracks = this.tracks.total
    )
}

fun PagedList<SimplifiedPlaylistJson?>.toSimplifiedPlaylistList(): List<SimplifiedPlaylist> =
    this.items.mapNotNull { it?.toSimplifiedPlaylist() }
