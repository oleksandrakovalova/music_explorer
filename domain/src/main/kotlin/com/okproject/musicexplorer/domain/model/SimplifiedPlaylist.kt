package com.okproject.musicexplorer.domain.model

data class SimplifiedPlaylist(
    val id: String,
    val name: String,
    val image: String,
    val totalTracks: Int,
    val description: String? = null,
    val owner: String? = null
)
