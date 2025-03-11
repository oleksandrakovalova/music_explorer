package com.okproject.musicexplorer.domain.model

data class Track(
    val id: String,
    val name: String,
    val album: String,
    val image: String,
    val artists: List<String>,
    val duration: Long
)
