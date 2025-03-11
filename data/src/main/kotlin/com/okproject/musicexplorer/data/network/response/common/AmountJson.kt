package com.okproject.musicexplorer.data.network.response.common

import kotlinx.serialization.Serializable

@Serializable
data class AmountJson(
    val href: String?,
    val total: Int
)
