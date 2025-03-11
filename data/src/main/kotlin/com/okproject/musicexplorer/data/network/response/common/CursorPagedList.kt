package com.okproject.musicexplorer.data.network.response.common

import kotlinx.serialization.Serializable

@Serializable
data class CursorPagedList<T>(
    val href: String,
    val limit: Int,
    val next: String?,
    val cursors: CursorJson,
    val total: Int,
    val items: List<T>
)
