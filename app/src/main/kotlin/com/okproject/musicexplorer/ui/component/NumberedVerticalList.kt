package com.okproject.musicexplorer.ui.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.okproject.musicexplorer.ui.preview.providers.ImageListProvider
import com.okproject.musicexplorer.ui.theme.MusicExplorerTheme

@Composable
fun NumberedVerticalList(
    modifier: Modifier = Modifier,
    items: List<ImageItem>
) {
    LazyColumn(modifier = modifier) {
        items(items.size, key = { items[it].id }) {
            NumberedRowContainer(
                number = it + 1,
                imageUrl = items[it].imageUrl,
                title = items[it].title,
                subtitle = items[it].subtitle
            )
        }
    }
}

@PreviewLightDark
@Composable
fun NumberedVerticalListPreview(
    @PreviewParameter(ImageListProvider::class) items: List<ImageItem>
) {
    MusicExplorerTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            NumberedVerticalList(items = items)
        }
    }
}