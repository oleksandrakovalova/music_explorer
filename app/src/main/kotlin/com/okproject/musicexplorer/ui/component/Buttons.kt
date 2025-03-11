package com.okproject.musicexplorer.ui.component

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.okproject.musicexplorer.ui.preview.providers.BooleanParameterProvider
import com.okproject.musicexplorer.ui.theme.Dimens
import com.okproject.musicexplorer.ui.theme.MusicExplorerTheme

@Composable
fun PrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    ElevatedButton(
        modifier = modifier,
        onClick = onClick,
        enabled = enabled,
        colors = ButtonColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            disabledContainerColor = MaterialTheme.colorScheme.surfaceVariant,
            disabledContentColor = MaterialTheme.colorScheme.onSurfaceVariant
        )
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(
                horizontal = Dimens.fullPadding,
                vertical = Dimens.mediumPadding
            ),
            style = MaterialTheme.typography.labelLarge
        )
    }
}

@PreviewLightDark
@Composable
fun PrimaryButtonPreview(@PreviewParameter(BooleanParameterProvider::class) isEnabled: Boolean) {
    MusicExplorerTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.wrapContentSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            PrimaryButton(
                text = "Primary",
                onClick = {},
                enabled = isEnabled
            )
        }
    }
}