package com.okproject.musicexplorer.ui.component

import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardActionScope
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import com.okproject.musicexplorer.R
import com.okproject.musicexplorer.ui.preview.PreviewCombined
import com.okproject.musicexplorer.ui.theme.MusicExplorerTheme

@Composable
fun SearchInput(
    inputValue: String,
    onInputValueChanged: (String) -> Unit,
    placeholder: String,
    onSearchImeAction: KeyboardActionScope.() -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(
        value = inputValue,
        onValueChange = onInputValueChanged,
        modifier = modifier,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(onSearch = onSearchImeAction),
        placeholder = { Text(placeholder) },
        singleLine = true,
        leadingIcon = {
            Icon(
                Icons.Default.Search,
                contentDescription = null
            )
        }
    )
}

@PreviewCombined
@Composable
fun SearchInputPreview() {
    var inputValue by remember { mutableStateOf("") }
    MusicExplorerTheme {
        Surface(
            modifier = Modifier.wrapContentSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            SearchInput(
                inputValue = inputValue,
                onInputValueChanged = { newValue -> inputValue = newValue },
                onSearchImeAction = {},
                placeholder = stringResource(R.string.search_placeholder)
            )
        }
    }
}