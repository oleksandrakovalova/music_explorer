package com.okproject.musicexplorer.userschart

import com.okproject.musicexplorer.domain.model.Track
import com.okproject.musicexplorer.domain.userschart.GetUsersTopTracksUseCase
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class TopTracksViewModel(
    getUsersTopTracksUseCase: GetUsersTopTracksUseCase
): TopItemsViewModel<Track>(getUsersTopTracksUseCase) {
    val topTracks: StateFlow<List<Track>> =
        topItems.asStateFlow()
}