package com.okproject.musicexplorer.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.okproject.musicexplorer.auth.AuthorizationState
import com.okproject.musicexplorer.auth.AuthorizationViewModel
import com.okproject.musicexplorer.login.LoginScreen
import com.okproject.musicexplorer.findActivity
import com.okproject.musicexplorer.di.koinActivityViewModel
import com.okproject.musicexplorer.main.MainHostContainer
import com.okproject.musicexplorer.spotify.SpotifyLogin.loginInBrowser
import com.okproject.musicexplorer.navigation.Navigator.navigateToAuthRoute
import com.okproject.musicexplorer.navigation.Navigator.navigateToMainRoute
import com.okproject.musicexplorer.splash.SplashScreen

@Composable
fun AppNavHost(
    navController: NavHostController = rememberNavController(),
    authorizationViewModel: AuthorizationViewModel = koinActivityViewModel()
) {
    // TODO check navigation with a scenario when unauthorized error received
    val authState by authorizationViewModel.authorizationStateFlow.collectAsStateWithLifecycle()
    LaunchedEffect(authState) {
        when {
            authState == AuthorizationState.AUTHORIZED -> {
                navController.navigateToMainRoute()
            }
            authState == AuthorizationState.UNAUTHORIZED && !navController.isCurrentRoute(Screen.Login) -> {
                navController.navigateToAuthRoute()
            }
        }
    }

    NavHost(
        navController = navController,
        route = Graph.Root::class,
        startDestination = Screen.Splash
    ) {
        composable<Screen.Splash> {
            SplashScreen()
        }
        composable<Graph.Main> {
            MainHostContainer()
        }
        this.authGraph()
    }
}