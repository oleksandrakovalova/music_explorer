package com.okproject.musicexplorer.main

import android.graphics.Bitmap
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.okproject.musicexplorer.di.koinActivityViewModel
import com.okproject.musicexplorer.navigation.MainNavHost
import com.okproject.musicexplorer.navigation.bottomNavigationRoutes
import com.okproject.musicexplorer.ui.component.NavigationBottomBar
import com.okproject.musicexplorer.ui.preview.PreviewCombined
import com.okproject.musicexplorer.ui.theme.MusicExplorerTheme

@Composable
fun MainHostContainer(
    currentlyPlayingViewModel: CurrentlyPlayingViewModel = koinActivityViewModel(),
    navController: NavHostController = rememberNavController()
) {
    val track by currentlyPlayingViewModel.currentTrackFlow.collectAsStateWithLifecycle()
    val cover by currentlyPlayingViewModel.coverImageFlow.collectAsStateWithLifecycle()

    MainHostContainerContent(
        track = track,
        cover = cover,
        navController = navController
    ) { innerPaddings ->
        MainNavHost(
            navController = navController,
            modifier = Modifier.padding(innerPaddings)
        )
    }
}

@Composable
fun MainHostContainerContent(
    track: PlayingTrackData?,
    cover: Bitmap?,
    navController: NavHostController = rememberNavController(),
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        bottomBar = {
            Column {
                track?.let {
                    CurrentlyPlayingContent(
                        title = it.name,
                        image = cover,
                        artists = it.artists.joinToString()
                    )
                }
                NavigationBottomBar(
                    routes = bottomNavigationRoutes(),
                    navController = navController
                )
            }
        }
    ) { innerPaddings ->
        content(innerPaddings)
    }
}

@PreviewCombined
@Composable
fun MainHostContainerContentPreview() {
    MusicExplorerTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            MainHostContainerContent(
                track = PlayingTrackData(
                    name = "Midnight",
                    artists = listOf("Lianne La Havas"),
                    imageUri = null
                ),
                cover = null
            ) { innerPadding ->
                Text("Preview", modifier = Modifier.padding(innerPadding))
            }
        }
    }
}