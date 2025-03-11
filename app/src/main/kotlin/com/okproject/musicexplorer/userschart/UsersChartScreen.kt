package com.okproject.musicexplorer.userschart

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.okproject.musicexplorer.R
import com.okproject.musicexplorer.ui.component.TabHeader

@Composable
fun UsersChartScreen() {
    val tabLabels = listOf(stringResource(id = R.string.artists_label), stringResource(id = R.string.tracks_label))
    val pagerState = rememberPagerState { tabLabels.size }

    Column {
        TabHeader(
            pagerState = pagerState,
            tabLabels = tabLabels
        )
        UsersChartTabPager(
            pagerState = pagerState
        )
    }
}

@Composable
fun UsersChartTabPager(
    pagerState: PagerState
) {
    HorizontalPager(state = pagerState) { index ->
        when(index) {
            0 -> TopArtistsPage()
            1 -> TopTracksPage()
        }
    }
}