package com.okproject.musicexplorer.data.network.response.common

import kotlinx.serialization.Serializable

@Serializable
data class ExternalIdJson(
    val isrc: String = "",
    val ean: String = "",
    val upc: String = ""
)
