package com.okproject.musicexplorer.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.okproject.musicexplorer.R
import com.okproject.musicexplorer.domain.model.SimplifiedPlaylist
import com.okproject.musicexplorer.ui.component.InfocardContainer
import com.okproject.musicexplorer.ui.component.SearchInput
import com.okproject.musicexplorer.ui.preview.PreviewCombined
import com.okproject.musicexplorer.ui.preview.providers.SimplifiedPlaylistListProvider
import com.okproject.musicexplorer.ui.theme.Dimens
import com.okproject.musicexplorer.ui.theme.MusicExplorerTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun SearchScreen(
    viewModel: SearchViewModel = koinViewModel()
) {
    val query by viewModel.queryFlow.collectAsStateWithLifecycle()
    val results by viewModel.playlistsFlow.collectAsStateWithLifecycle()

    SearchScreenContent(
        query = query,
        onQueryChanged = viewModel::onQueryChanged,
        onSearchKeyClicked = viewModel::search,
        results = results
    )
}

@Composable
fun SearchScreenContent(
    query: String,
    onQueryChanged: (String) -> Unit,
    onSearchKeyClicked: () -> Unit,
    results: List<SimplifiedPlaylist>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        SearchInput(
            inputValue = query,
            onInputValueChanged = onQueryChanged,
            placeholder = stringResource(R.string.search_placeholder),
            onSearchImeAction = { onSearchKeyClicked() },
            modifier = Modifier.fillMaxWidth().padding(Dimens.largePadding)
        )
        LazyColumn(
            modifier = modifier,
            contentPadding = PaddingValues(Dimens.mediumPadding)
        ) {
            items(results.size, key = { results[it].id }) { index ->
                InfocardContainer(
                    title = results[index].name,
                    image = results[index].image,
                    subtitle = results[index].owner,
                    description = results[index].description
                )
            }
        }
    }
}

@PreviewCombined
@Composable
fun SearchScreenContentPreview(
    @PreviewParameter(SimplifiedPlaylistListProvider::class) results: List<SimplifiedPlaylist>
) {
    var query by remember { mutableStateOf("") }
    MusicExplorerTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            SearchScreenContent(
                query = query,
                onQueryChanged = { newQuery -> query = newQuery },
                onSearchKeyClicked = {},
                results = results
            )
        }
    }
}
