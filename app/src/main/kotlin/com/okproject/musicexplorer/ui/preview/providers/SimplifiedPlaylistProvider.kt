package com.okproject.musicexplorer.ui.preview.providers

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.okproject.musicexplorer.domain.model.SimplifiedPlaylist

class SimplifiedPlaylistProvider: PreviewParameterProvider<SimplifiedPlaylist> {
    override val values: Sequence<SimplifiedPlaylist> =
        sequenceOf(
            SimplifiedPlaylist(
                id = "pl_j_pop",
                name = "J-Pop Mix",
                image = "j_pop_mix.jpg",
                totalTracks = 12,
                owner = "My Account"
            ),
            SimplifiedPlaylist(
                id = "pl_big_in_japan",
                name = "Big In Japan",
                image = "big_in_japan.jpg",
                totalTracks = 50,
                description = "Discover most popular music from the Land of the Rising Sun. Updated every week on Fridays.",
                owner = "Spotify"
            ),
            SimplifiedPlaylist(
                id = "pl_top_global_chart",
                name = "Top Chart Global",
                image = "top_chart_global.jpg",
                totalTracks = 10,
                description = "Weekly selection of global top chart"
            ),
            SimplifiedPlaylist(
                id = "pl_private_mode",
                name = "Private Mode",
                image = "private_mode.jpg",
                totalTracks = 26
            ),
        )
}