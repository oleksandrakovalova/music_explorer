package com.okproject.musicexplorer.data.network.response.content

import com.okproject.musicexplorer.data.network.response.album.SimplifiedAlbumJson
import com.okproject.musicexplorer.data.network.response.artist.SimplifiedArtistJson
import com.okproject.musicexplorer.data.network.response.common.ExternalIdJson
import com.okproject.musicexplorer.data.network.response.common.ExternalUrlJson
import com.okproject.musicexplorer.data.network.response.common.RestrictionJson
import com.okproject.musicexplorer.data.network.response.track.LinkedTrackJson
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("track")
data class TrackJson(
    val album: SimplifiedAlbumJson,
    val artists: List<SimplifiedArtistJson>,
    @SerialName("available_markets")
    val availableMarkets: List<String>,
    @SerialName("disc_number")
    val discNumber: Int,
    @SerialName("duration_ms")
    val durationMs: Long,
    val explicit: Boolean,
    @SerialName("external_ids")
    val externalIds: ExternalIdJson,
    @SerialName("external_urls")
    override val externalUrls: ExternalUrlJson,
    override val href: String,
    override val id: String,
    @SerialName("is_playable")
    val isPlayable: Boolean? = null,
    @SerialName("linked_from")
    val linkedFrom: LinkedTrackJson? = null,
    val restrictions: RestrictionJson? = null,
    override val name: String,
    val popularity: Int,
    @SerialName("preview_url")
    val previewUrl: String?,
    @SerialName("track_number")
    val trackNumber: Int,
    override val type: String,
    override val uri: String,
    @SerialName("is_local")
    val isLocal: Boolean
): ContentJson
