package com.okproject.musicexplorer.domain.userschart

import com.okproject.musicexplorer.domain.model.Track

class GetUsersTopTracksUseCaseImpl(
    private val usersChartRepository: UsersChartRepository
): GetUsersTopTracksUseCase {
    override suspend fun invoke(period: ChartPeriod): Result<List<Track>> =
        usersChartRepository.getUsersTopTracks(period = period)
}