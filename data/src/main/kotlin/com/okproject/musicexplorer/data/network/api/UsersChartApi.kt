package com.okproject.musicexplorer.data.network.api

import com.okproject.musicexplorer.data.network.response.content.ContentJson
import com.okproject.musicexplorer.data.network.response.common.PagedList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface UsersChartApi {
    @GET("me/top/{type}")
    suspend fun getUserTopItems(
        @Path("type") type: String,
        @Query("time_range") timeRange: String,
        @Query("limit") limit: Int = DEFAULT_LIMIT,
        @Query("offset") offset: Int = DEFAULT_OFFSET
    ): Response<PagedList<ContentJson>>
}