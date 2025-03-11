package com.okproject.musicexplorer.data.network.response.playlist

import com.okproject.musicexplorer.data.network.response.content.ContentJson
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlaylistTrackJson(
    @SerialName("added_at")
    val addedAt: String,
    @SerialName("added_by")
    val addedBy: OwnerJson?,
    @SerialName("is_local")
    val isLocal: Boolean,
    val track: ContentJson
)
