package com.okproject.musicexplorer.domain.userschart

import com.okproject.musicexplorer.domain.model.Artist

class GetUsersTopArtistsUseCaseImpl(
    private val usersChartRepository: UsersChartRepository
): GetUsersTopArtistsUseCase {
    override suspend fun invoke(period: ChartPeriod): Result<List<Artist>> =
        usersChartRepository.getUsersTopArtists(period = period)
}