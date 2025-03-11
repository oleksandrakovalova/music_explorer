package com.okproject.musicexplorer.data.network.response.track

import com.okproject.musicexplorer.data.network.response.common.ExternalUrlJson
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LinkedTrackJson(
    @SerialName("external_urls")
    val externalUrls: ExternalUrlJson? = null,
    val href: String? = null,
    val id: String? = null,
    val type: String? = null,
    val uri: String? = null
)
