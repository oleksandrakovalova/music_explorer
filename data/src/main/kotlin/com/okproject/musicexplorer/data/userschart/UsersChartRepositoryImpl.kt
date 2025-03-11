package com.okproject.musicexplorer.data.userschart

import com.okproject.musicexplorer.data.mapper.toArtistList
import com.okproject.musicexplorer.data.mapper.toTrackList
import com.okproject.musicexplorer.data.network.api.UsersChartApi
import com.okproject.musicexplorer.data.network.toResult
import com.okproject.musicexplorer.domain.model.Artist
import com.okproject.musicexplorer.domain.model.Track
import com.okproject.musicexplorer.domain.userschart.ChartPeriod
import com.okproject.musicexplorer.domain.userschart.UsersChartRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import timber.log.Timber

class UsersChartRepositoryImpl(
    private val usersChartApi: UsersChartApi,
    private val dispatcher: CoroutineDispatcher
): UsersChartRepository {
    override suspend fun getUsersTopArtists(period: ChartPeriod): Result<List<Artist>> =
        withContext(dispatcher) {
            try {
                usersChartApi.getUserTopItems(
                    type = TopItemType.ARTISTS,
                    timeRange = period.toTimeRange().toQueryParam(),
                    limit = TOP_CHART_LIMIT
                ).toResult {
                    it.toArtistList()
                }
            } catch (exception: Exception) {
                Timber.e(exception, "Top Artists request is failed with exception")
                Result.failure(exception)
            }
        }

    override suspend fun getUsersTopTracks(period: ChartPeriod): Result<List<Track>> =
        withContext(dispatcher) {
            try {
                usersChartApi.getUserTopItems(
                    type = TopItemType.TRACKS,
                    timeRange = period.toTimeRange().toQueryParam(),
                    limit = TOP_CHART_LIMIT
                ).toResult {
                    it.toTrackList()
                }
            } catch (exception: Exception) {
                Timber.e(exception, "Top Tracks request is failed with exception")
                Result.failure(exception)
            }
    }
}

private const val TOP_CHART_LIMIT = 10
private object TopItemType {
    const val ARTISTS = "artists"
    const val TRACKS = "tracks"
}

private fun ChartPeriod.toTimeRange(): TimeRange =
    when(this) {
        ChartPeriod.YEAR -> TimeRange.LONG_TERM
        ChartPeriod.SIX_MONTHS -> TimeRange.MEDIUM_TERM
        ChartPeriod.MONTH -> TimeRange.SHORT_TERM
    }