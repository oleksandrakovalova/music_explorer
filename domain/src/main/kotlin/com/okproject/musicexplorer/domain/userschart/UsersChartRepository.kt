package com.okproject.musicexplorer.domain.userschart

import com.okproject.musicexplorer.domain.model.Artist
import com.okproject.musicexplorer.domain.model.Track

interface UsersChartRepository {
    suspend fun getUsersTopArtists(period: ChartPeriod): Result<List<Artist>>
    suspend fun getUsersTopTracks(period: ChartPeriod): Result<List<Track>>
}