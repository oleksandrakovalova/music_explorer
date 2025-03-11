package com.okproject.musicexplorer.ui.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.ElevatedFilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.okproject.musicexplorer.ui.theme.MusicExplorerTheme

@Composable
fun ChipGroup(
    modifier: Modifier = Modifier,
    chips: List<ChipItem>,
    onSelected: (id: String) -> Unit
) {
    var selected: String by rememberSaveable { mutableStateOf(chips[0].id) }
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 8.dp)
    ) {
        items(count = chips.size, key = { chips[it] }) { index ->
            SelectableChip(
                modifier = Modifier.padding(8.dp),
                selected = selected == chips[index].id,
                onSelected = {
                    selected = chips[index].id
                    onSelected(chips[index].id)
                },
                label = chips[index].label
            )
        }
    }
}

@Composable
fun SelectableChip(
    selected: Boolean,
    onSelected: (Boolean) -> Unit,
    label: String,
    modifier: Modifier = Modifier
) {
    ElevatedFilterChip(
        modifier = modifier,
        onClick = { onSelected(selected) },
        label = { Text(label) },
        selected = selected,
        leadingIcon = if (selected) {
            {
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = null,
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            }
        } else {
            null
        }
    )
}

@PreviewLightDark
@Composable
fun ChipGroupPreview() {
    MusicExplorerTheme {
        ChipGroup(
            chips = listOf(
                ChipItem(
                    id = "year",
                    label = "Year"
                ),
                ChipItem(
                    id = "six_months",
                    label = "6 Months"
                ),
                ChipItem(
                    id = "month",
                    label = "Month"
                )
            ),
            onSelected = {}
        )
    }
}