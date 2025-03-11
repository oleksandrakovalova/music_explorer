package com.okproject.musicexplorer.ui.preview.providers

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.okproject.musicexplorer.domain.model.SimplifiedPlaylist

class SimplifiedPlaylistListProvider: PreviewParameterProvider<List<SimplifiedPlaylist>> {
    private val playlists = buildList {
        for (i in 1..15) {
            add(
                SimplifiedPlaylist(
                    id = "pl_#$i",
                    name = "Daily Mix # $i",
                    image = "daily_mix_$i.jpg",
                    totalTracks = 15,
                    description = "Your daily selection #$i of favorite songs",
                    owner = "My Account",
                )
            )
        }
    }
    override val values: Sequence<List<SimplifiedPlaylist>> =
        sequenceOf(
            playlists
        )
}