package com.okproject.musicexplorer.userschart

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.okproject.musicexplorer.mapper.toImageItemData
import com.okproject.musicexplorer.ui.component.FilteredListPage
import com.okproject.musicexplorer.ui.component.ImageContainerList
import org.koin.androidx.compose.koinViewModel

@Composable
fun TopArtistsPage(
    viewModel: TopArtistsViewModel = koinViewModel()
) {
    val artists by viewModel.topArtists.collectAsStateWithLifecycle()
    FilteredListPage(
        items = artists.map { it.toImageItemData() },
        filters = chartPeriodFilters(),
        onFilterSelected = { filterId -> viewModel.onChartPeriodSelected(filterId) }
    )
}