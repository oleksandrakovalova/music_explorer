package com.okproject.musicexplorer.data.network.response.common

import kotlinx.serialization.Serializable

@Serializable
data class PagedList<T>(
    val href: String,
    val limit: Int,
    val next: String?,
    val offset: Int,
    val previous: String?,
    val total: Int,
    val items: List<T>
)