package com.okproject.musicexplorer.spotify

import com.okproject.musicexplorer.main.PlayingTrackData


typealias AppRemoteTrack = com.spotify.protocol.types.Track

fun AppRemoteTrack.toPlayerTrackData(): PlayingTrackData =
    PlayingTrackData(
        name = this.name,
        artists = this.artists?.mapNotNull { it?.name } ?: emptyList(),
        imageUri = this.imageUri
    )