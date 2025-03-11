package com.okproject.musicexplorer.data.network.response.content

import com.okproject.musicexplorer.data.network.response.common.ExternalUrlJson
import kotlinx.serialization.Serializable

@Serializable
sealed interface ContentJson {
    val externalUrls: ExternalUrlJson
    val href: String
    val id: String
    val name: String
    val type: String
    val uri: String
}