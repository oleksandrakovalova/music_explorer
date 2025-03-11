package com.okproject.musicexplorer.data.mapper

import com.okproject.musicexplorer.data.network.response.content.ContentJson
import com.okproject.musicexplorer.data.network.response.common.PagedList
import com.okproject.musicexplorer.data.network.response.content.TrackJson
import com.okproject.musicexplorer.domain.model.Track
import timber.log.Timber

//TODO remove temporary debug logs
private const val MAPPER_TAG = "TrackMapper"
fun TrackJson.toTrack(): Track {
    Timber.tag(MAPPER_TAG).d(this.toString())
    return Track(
        id = this.id,
        name = this.name,
        album = this.album.name,
        artists = this.artists.names(),
        image = this.album.images.firstOrNull()?.url ?: "",
        duration = this.durationMs
    )
}


fun PagedList<ContentJson>.toTrackList(): List<Track> =
    this.items
        .mapNotNull {
            when (it) {
                is TrackJson -> it.toTrack()
                else -> null
            }
        }