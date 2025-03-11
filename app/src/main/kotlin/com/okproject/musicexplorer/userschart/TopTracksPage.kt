package com.okproject.musicexplorer.userschart

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.okproject.musicexplorer.mapper.toImageItemData
import com.okproject.musicexplorer.ui.component.FilteredListPage
import org.koin.androidx.compose.koinViewModel

@Composable
fun TopTracksPage(
    viewModel: TopTracksViewModel = koinViewModel()
) {
    val tracks by viewModel.topTracks.collectAsStateWithLifecycle()
    FilteredListPage(
        items = tracks.map { it.toImageItemData() },
        filters = chartPeriodFilters(),
        onFilterSelected = { filterId -> viewModel.onChartPeriodSelected(filterId) }
    )
}