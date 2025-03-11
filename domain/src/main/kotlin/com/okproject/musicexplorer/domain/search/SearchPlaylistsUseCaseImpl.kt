package com.okproject.musicexplorer.domain.search

import com.okproject.musicexplorer.domain.model.SimplifiedPlaylist

class SearchPlaylistsUseCaseImpl(
    private val searchRepository: SearchRepository
): SearchPlaylistsUseCase {
    override suspend fun invoke(query: String): Result<List<SimplifiedPlaylist>> =
        searchRepository.searchPlaylists(query)
}