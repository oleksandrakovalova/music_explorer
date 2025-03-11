package com.okproject.musicexplorer.data.network.response.album

import com.okproject.musicexplorer.data.network.response.artist.SimplifiedArtistJson
import com.okproject.musicexplorer.data.network.response.common.ExternalUrlJson
import com.okproject.musicexplorer.data.network.response.common.ImageJson
import com.okproject.musicexplorer.data.network.response.common.RestrictionJson
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SimplifiedAlbumJson(
    @SerialName("album_type")
    val albumType: String,
    @SerialName("total_tracks")
    val totalTracks: Int,
    @SerialName("available_markets")
    val availableMarkets: List<String>,
    @SerialName("external_urls")
    val externalUrls: ExternalUrlJson,
    val href: String,
    val id: String,
    val images: List<ImageJson>,
    val name: String,
    @SerialName("release_date")
    val releaseDate: String,
    @SerialName("release_date_precision")
    val releaseDatePrecision: String,
    val restrictions: RestrictionJson? = null,
    val type: String,
    val uri: String,
    val artists: List<SimplifiedArtistJson>
)
