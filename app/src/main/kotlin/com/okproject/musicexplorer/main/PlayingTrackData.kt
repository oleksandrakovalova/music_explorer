package com.okproject.musicexplorer.main

import com.spotify.protocol.types.ImageUri

data class PlayingTrackData(
    val name: String,
    val artists: List<String>,
    val imageUri: ImageUri?
)
