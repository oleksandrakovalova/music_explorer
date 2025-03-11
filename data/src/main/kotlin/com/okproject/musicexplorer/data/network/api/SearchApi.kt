package com.okproject.musicexplorer.data.network.api

import com.okproject.musicexplorer.data.network.response.search.SearchResultJson
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchApi {
    @GET("search")
    suspend fun search(
        @Query("q") query: String,
        @Query("type", encoded = true) type: String,
        @Query("limit") limit: Int = DEFAULT_LIMIT,
        @Query("offset") offset: Int = DEFAULT_OFFSET
    ): Response<SearchResultJson>
}