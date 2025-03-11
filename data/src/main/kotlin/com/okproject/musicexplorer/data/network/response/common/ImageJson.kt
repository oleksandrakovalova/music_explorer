package com.okproject.musicexplorer.data.network.response.common

import kotlinx.serialization.Serializable

@Serializable
data class ImageJson(
    val url: String,
    val height: Int?,
    val width: Int?
)
