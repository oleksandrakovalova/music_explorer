package com.okproject.musicexplorer.userschart

import com.okproject.musicexplorer.domain.model.Artist
import com.okproject.musicexplorer.domain.userschart.GetUsersTopArtistsUseCase
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class TopArtistsViewModel (
    getUsersTopArtistsUseCase: GetUsersTopArtistsUseCase
): TopItemsViewModel<Artist>(getUsersTopArtistsUseCase) {

    val topArtists: StateFlow<List<Artist>> =
        topItems.asStateFlow()
}