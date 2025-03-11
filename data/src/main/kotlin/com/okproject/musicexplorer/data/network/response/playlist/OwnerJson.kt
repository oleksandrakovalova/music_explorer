package com.okproject.musicexplorer.data.network.response.playlist

import com.okproject.musicexplorer.data.network.response.common.AmountJson
import com.okproject.musicexplorer.data.network.response.common.ExternalUrlJson
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OwnerJson(
    @SerialName("external_urls")
    val externalUrls: ExternalUrlJson,
    val followers: AmountJson? = null,
    val href: String,
    val id: String,
    val type: String,
    val uri: String,
    @SerialName("display_name")
    val displayName: String? = null
)
