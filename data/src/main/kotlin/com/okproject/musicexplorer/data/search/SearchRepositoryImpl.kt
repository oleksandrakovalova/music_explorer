package com.okproject.musicexplorer.data.search

import com.okproject.musicexplorer.data.mapper.toSimplifiedPlaylistList
import com.okproject.musicexplorer.data.network.api.SearchApi
import com.okproject.musicexplorer.data.network.toResult
import com.okproject.musicexplorer.domain.model.SimplifiedPlaylist
import com.okproject.musicexplorer.domain.search.SearchRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import timber.log.Timber

class SearchRepositoryImpl(
    private val searchApi: SearchApi,
    private val dispatcher: CoroutineDispatcher
): SearchRepository {
    override suspend fun searchPlaylists(query: String): Result<List<SimplifiedPlaylist>> =
        withContext(dispatcher) {
            try {
                searchApi.search(query = query, type = SearchType.PLAYLIST).toResult {
                    it.playlists?.toSimplifiedPlaylistList() ?: emptyList()
                }
            } catch (exception: Exception) {
                Timber.e(exception, "Playlist's search request is failed with exception")
                Result.failure(exception)
            }
        }
}

private object SearchType {
    const val ALBUM = "album"
    const val ARTIST = "artist"
    const val PLAYLIST = "playlist"
    const val TRACK = "track"
}