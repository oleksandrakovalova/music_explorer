package com.okproject.musicexplorer.data.network.api

import com.okproject.musicexplorer.data.network.response.common.PagedList
import com.okproject.musicexplorer.data.network.response.playlist.PlaylistTrackJson
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PlaylistApi {
    @GET("playlists/{playlist_id}/tracks")
    suspend fun getPlaylistTracks(
        @Path("playlist_id") playlistId: String,
        @Query("limit") limit: Int = DEFAULT_LIMIT,
        @Query("offset") offset: Int = DEFAULT_OFFSET
    ): Response<PagedList<PlaylistTrackJson>>
}