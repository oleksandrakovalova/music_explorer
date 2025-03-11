package com.okproject.musicexplorer.domain.search

import com.okproject.musicexplorer.domain.model.SimplifiedPlaylist

interface SearchPlaylistsUseCase {
    suspend operator fun invoke(query: String): Result<List<SimplifiedPlaylist>>
}