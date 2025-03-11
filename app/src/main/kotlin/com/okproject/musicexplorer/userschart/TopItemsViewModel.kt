package com.okproject.musicexplorer.userschart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.okproject.musicexplorer.domain.userschart.ChartPeriod
import com.okproject.musicexplorer.domain.userschart.GetTopItemsUseCase
import com.okproject.musicexplorer.mapper.toChartPeriod
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

abstract class TopItemsViewModel<T>(
    private val getTopItemsUseCase: GetTopItemsUseCase<T>
): ViewModel() {
    protected val topItems: MutableStateFlow<List<T>> =
        MutableStateFlow(emptyList())
    private val selectedChartPeriod: MutableStateFlow<ChartPeriod> =
        MutableStateFlow(ChartPeriod.YEAR)

    init {
        viewModelScope.launch {
            selectedChartPeriod.onEach {
                fetchTopItems(it)
            }.collect()
        }
    }

    private suspend fun fetchTopItems(period: ChartPeriod) {
        val result = getTopItemsUseCase(period)
        if (result.isSuccess) {
            topItems.emit(result.getOrNull() ?: emptyList())
        }
    }

    fun onChartPeriodSelected(periodFilter: String) {
        viewModelScope.launch {
            selectedChartPeriod.emit(periodFilter.toChartPeriod())
        }
    }
}