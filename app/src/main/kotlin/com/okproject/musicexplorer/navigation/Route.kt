package com.okproject.musicexplorer.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import com.okproject.musicexplorer.R
import kotlinx.serialization.Serializable

@Serializable
sealed class Screen {
    @Serializable data object Splash: Screen()
    @Serializable data object Login: Screen()
    @Serializable data object UsersChart: Screen()
    @Serializable data object Home: Screen()
    @Serializable data object Search: Screen()
}

@Serializable
sealed class Graph {
    @Serializable
    data object Root: Graph()
    @Serializable
    data object Auth: Graph()
    @Serializable
    data object Main: Graph()
}

data class BottomNavigationRoute(
    val destination: Screen,
    val title: String,
    val icon: ImageVector
)

@Composable
fun bottomNavigationRoutes() = listOf(
    BottomNavigationRoute(
        title = stringResource(R.string.home_label),
        destination = Screen.Home,
        icon = Icons.Default.Home
    ),
    BottomNavigationRoute(
        title = stringResource(R.string.search_label),
        destination = Screen.Search,
        icon = Icons.Default.Search
    ),
    BottomNavigationRoute(
        title = stringResource(R.string.users_top_label),
        destination = Screen.UsersChart,
        icon = Icons.Default.Star
    )
)