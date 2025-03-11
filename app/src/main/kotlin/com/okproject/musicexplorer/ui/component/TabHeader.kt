package com.okproject.musicexplorer.ui.component

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.SecondaryIndicator
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.okproject.musicexplorer.ui.theme.MusicExplorerTheme
import kotlinx.coroutines.launch

@Composable
fun TabHeader(
    pagerState: PagerState,
    tabLabels: List<String>,
    modifier: Modifier = Modifier
) {
    val scope = rememberCoroutineScope()
    TabRow(
        modifier = modifier,
        selectedTabIndex = pagerState.currentPage,
        divider = {
            Spacer(modifier = Modifier.height(6.dp))
        },
        indicator = { tabPositions ->
            SecondaryIndicator(
                modifier = Modifier.tabIndicatorOffset(currentTabPosition = tabPositions[pagerState.currentPage])
            )
        }
    ) {
        tabLabels.forEachIndexed { index, label ->
            Tab(
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
                text = {
                    Text(
                        text = label,
                        style = MaterialTheme.typography.labelLarge
                    )
                }
            )
        }
    }
}

@PreviewLightDark
@Composable
fun TabHeaderPreview() {
    val tabs = listOf("Top artists", "Top songs")
    MusicExplorerTheme {
        Surface(
            modifier = Modifier.wrapContentSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            TabHeader(
                pagerState = rememberPagerState { tabs.size },
                tabLabels = tabs
            )
        }
    }
}