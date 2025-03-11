package com.okproject.musicexplorer.data.network.response.common

import kotlinx.serialization.Serializable

@Serializable
data class CursorJson(
    val after: String,
    val before: String
)
