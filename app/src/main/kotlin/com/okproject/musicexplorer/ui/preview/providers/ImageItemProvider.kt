package com.okproject.musicexplorer.ui.preview.providers

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.okproject.musicexplorer.ui.component.ImageItem

class ImageItemProvider: PreviewParameterProvider<ImageItem> {
    override val values: Sequence<ImageItem> =
        sequenceOf(
            ImageItem(
                id = "artist",
                imageUrl = "artist.jpg",
                title = "Top Artist"
            ),
            ImageItem(
                id = "track",
                imageUrl = "track.jpg",
                title = "Top Track",
                subtitle = "Artist"
            )
        )
}