package com.okproject.musicexplorer.splash


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.okproject.musicexplorer.R
import com.okproject.musicexplorer.ui.theme.CustomTypography
import com.okproject.musicexplorer.ui.theme.MusicExplorerTheme

@Composable
fun SplashScreen() {
    Box(
        modifier = Modifier.fillMaxSize()
            .padding(24.dp),
        contentAlignment = Alignment.Center

    ) {
        Text(
            text = stringResource(R.string.app_name),
            textAlign = TextAlign.Center,
            style = CustomTypography.displayLarge
        )
    }
}

@PreviewLightDark
@Composable
fun SplashScreenPreview() {
    MusicExplorerTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            SplashScreen()
        }
    }
}