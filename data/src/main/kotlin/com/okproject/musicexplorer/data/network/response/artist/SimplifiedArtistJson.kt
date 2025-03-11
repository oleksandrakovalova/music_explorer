package com.okproject.musicexplorer.data.network.response.artist

import com.okproject.musicexplorer.data.network.response.common.ExternalUrlJson
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SimplifiedArtistJson(
    @SerialName("external_urls")
    val externalUrls: ExternalUrlJson,
    val href: String,
    val id: String,
    val name: String,
    val type: String,
    val uri: String
)
