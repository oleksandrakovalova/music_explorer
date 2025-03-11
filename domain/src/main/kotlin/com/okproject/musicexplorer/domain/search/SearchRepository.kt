package com.okproject.musicexplorer.domain.search

import com.okproject.musicexplorer.domain.model.SimplifiedPlaylist

// TODO implement Repository that implements interface
// TODO init repository within DI
interface SearchRepository {
    suspend fun searchPlaylists(query: String): Result<List<SimplifiedPlaylist>>
}