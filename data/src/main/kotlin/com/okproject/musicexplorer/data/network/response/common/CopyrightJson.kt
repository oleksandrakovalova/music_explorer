package com.okproject.musicexplorer.data.network.response.common

import kotlinx.serialization.Serializable

@Serializable
data class CopyrightJson(
    val text: String = "",
    val type: String = ""
)
