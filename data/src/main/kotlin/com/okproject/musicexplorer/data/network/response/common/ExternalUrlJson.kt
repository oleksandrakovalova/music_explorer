package com.okproject.musicexplorer.data.network.response.common

import kotlinx.serialization.Serializable

@Serializable
data class ExternalUrlJson(
    val spotify: String = ""
)
