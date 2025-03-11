package com.okproject.musicexplorer.data.mapper

import com.okproject.musicexplorer.data.network.response.content.ArtistJson
import com.okproject.musicexplorer.data.network.response.artist.SimplifiedArtistJson
import com.okproject.musicexplorer.data.network.response.content.ContentJson
import com.okproject.musicexplorer.data.network.response.common.PagedList
import com.okproject.musicexplorer.domain.model.Artist
import timber.log.Timber

// TODO remove temporary logs
private const val MAPPER_TAG = "ArtistMapper"
fun ArtistJson.toArtist(): Artist {
    Timber.tag(MAPPER_TAG).d(this.toString())
    return Artist(
        id = this.id,
        name = this.name,
        images = this.images.toImageList()
    )
}


fun PagedList<ContentJson>.toArtistList(): List<Artist> =
    this.items
        .mapNotNull {
            when (it) {
                is ArtistJson -> it.toArtist()
                else -> null
            }
        }

fun List<SimplifiedArtistJson>.names(): List<String> =
    this.map { it.name }