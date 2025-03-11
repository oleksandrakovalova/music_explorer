package com.okproject.musicexplorer.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.okproject.musicexplorer.R
import com.okproject.musicexplorer.ui.component.PrimaryButton
import com.okproject.musicexplorer.ui.preview.PreviewCombined
import com.okproject.musicexplorer.ui.theme.MusicExplorerTheme

@Composable
fun LoginScreen(
    onSignInButtonClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.container_inner_padding)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier
                .wrapContentSize()
                .padding(dimensionResource(id = R.dimen.text_padding)),
            text = stringResource(id = R.string.sign_in_title),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(dimensionResource(id = R.dimen.text_button_space)))
        PrimaryButton(
            text = stringResource(id = R.string.sign_in_button),
            onClick = onSignInButtonClicked
        )
    }
}

@PreviewCombined
@Composable
fun LoginScreenPreview() {
    MusicExplorerTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            LoginScreen(
                onSignInButtonClicked = {}
            )
        }
    }
}