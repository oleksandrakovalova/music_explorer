package com.okproject.musicexplorer.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.okproject.musicexplorer.search.SearchScreen
import com.okproject.musicexplorer.userschart.UsersChartScreen

@Composable
fun MainNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        route = Graph.Main::class,
        startDestination = Screen.Home
    ) {
        composable<Screen.Home> {
            // TODO implement Home Screen
            Text(text = "HOME SCREEN")
        }
        composable<Screen.UsersChart> {
            UsersChartScreen()
        }
        composable<Screen.Search> {
            SearchScreen()
        }
    }
}