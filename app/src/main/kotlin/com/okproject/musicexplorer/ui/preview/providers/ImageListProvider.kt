package com.okproject.musicexplorer.ui.preview.providers

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.okproject.musicexplorer.ui.component.ImageItem

class ImageListProvider: PreviewParameterProvider<List<ImageItem>> {
    private val artists = buildList {
        for (i in 1..10) {
            add(
                ImageItem(
                    id = "artist#$i",
                    imageUrl = "artist_$i.jpg",
                    title = "Top Artist #$i"
                )
            )
        }
    }
    private val tracks = buildList {
        for (i in 1..10) {
            add(
                ImageItem(
                    id = "track#$i",
                    imageUrl = "track_$i.jpg",
                    title = "Top Track #$i",
                    subtitle = "Artist #$i"
                )
            )
        }
    }
    override val values: Sequence<List<ImageItem>> =
        sequenceOf(
            artists,
            tracks
        )
}