package com.okproject.musicexplorer.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun FilteredListPage(
    items: List<ImageItem>,
    filters: List<ChipItem>,
    onFilterSelected: (id: String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        ChipGroup(
            chips = filters,
            onSelected = { onFilterSelected(it) }
        )
        NumberedVerticalList(items = items)
    }

}