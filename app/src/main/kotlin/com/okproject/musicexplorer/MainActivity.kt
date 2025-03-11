package com.okproject.musicexplorer

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.okproject.musicexplorer.auth.AuthorizationViewModel
import com.okproject.musicexplorer.navigation.AppNavHost
import com.okproject.musicexplorer.main.CurrentlyPlayingViewModel
import com.okproject.musicexplorer.spotify.SpotifyAppRemoteConnector
import com.okproject.musicexplorer.ui.theme.MusicExplorerTheme
import com.spotify.sdk.android.auth.AuthorizationResponse
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.compose.KoinContext

class MainActivity : ComponentActivity() {
    private val authorizationViewModel: AuthorizationViewModel by viewModel<AuthorizationViewModel>()
    private val currentlyPlayingViewModel: CurrentlyPlayingViewModel by viewModel<CurrentlyPlayingViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KoinContext {
                MusicExplorerTheme {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        AppNavHost()
                    }
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        SpotifyAppRemoteConnector.connect(this) {
            currentlyPlayingViewModel.onAppRemoteConnected(it)
        }
    }

    override fun onStop() {
        super.onStop()
        SpotifyAppRemoteConnector.disconnect {
            currentlyPlayingViewModel.onAppRemoteDisconnected()
        }
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        val data = intent.data
        if (data != null) {
            val response = AuthorizationResponse.fromUri(data)
            handleAuthorizationResponse(response)
        }
    }

    private fun handleAuthorizationResponse(response: AuthorizationResponse) {
        when(response.type) {
            AuthorizationResponse.Type.TOKEN -> {
                authorizationViewModel.onUserTokenUpdated(response.accessToken)
            }
            AuthorizationResponse.Type.ERROR -> {
                // TODO show error message?
            }
            else -> {}
        }
    }
}