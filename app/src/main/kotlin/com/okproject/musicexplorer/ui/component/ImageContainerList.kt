package com.okproject.musicexplorer.ui.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.okproject.musicexplorer.ui.preview.providers.ImageListProvider
import com.okproject.musicexplorer.ui.theme.Dimens
import com.okproject.musicexplorer.ui.theme.MusicExplorerTheme

@Composable
fun ImageContainerList(
    modifier: Modifier = Modifier,
    items: List<ImageItem>
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 180.dp),
        modifier = modifier,
        contentPadding = PaddingValues(Dimens.mediumPadding)
    ) {
        items(items.size, key = { items[it].id }) {
            ImageContainer(
                modifier = Modifier.padding(Dimens.mediumPadding),
                imageUrl = items[it].imageUrl,
                title = items[it].title,
                subtitle = items[it].subtitle
            )
        }
    }
}

@PreviewLightDark
@Composable
fun ImageItemsListPreview(
    @PreviewParameter(ImageListProvider::class) items: List<ImageItem>
) {
    MusicExplorerTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            ImageContainerList(items = items)
        }
    }
}