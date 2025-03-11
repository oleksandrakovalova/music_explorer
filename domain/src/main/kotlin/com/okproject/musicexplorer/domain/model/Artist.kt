package com.okproject.musicexplorer.domain.model

data class Artist(
    val id: String,
    val name: String,
    // TODO simplify to single image?
    val images: List<Image>
)
