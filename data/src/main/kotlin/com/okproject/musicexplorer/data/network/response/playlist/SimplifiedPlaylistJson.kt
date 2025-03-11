package com.okproject.musicexplorer.data.network.response.playlist

import com.okproject.musicexplorer.data.network.response.common.AmountJson
import com.okproject.musicexplorer.data.network.response.common.ExternalUrlJson
import com.okproject.musicexplorer.data.network.response.common.ImageJson
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SimplifiedPlaylistJson(
    val collaborative: Boolean,
    val description: String?,
    @SerialName("external_urls")
    val externalUrls: ExternalUrlJson,
    val href: String,
    val id: String,
    val images: List<ImageJson>,
    val name: String,
    val owner: OwnerJson,
    val public: Boolean,
    @SerialName("snapshot_id")
    val snapshotId: String,
    val tracks: AmountJson,
    val type: String,
    val uri: String
)
