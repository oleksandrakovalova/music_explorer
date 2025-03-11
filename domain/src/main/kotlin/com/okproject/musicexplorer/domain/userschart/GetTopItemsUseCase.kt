package com.okproject.musicexplorer.domain.userschart


interface GetTopItemsUseCase<T> {
    suspend operator fun invoke(period: ChartPeriod): Result<List<T>>
}