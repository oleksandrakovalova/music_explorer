package com.okproject.musicexplorer.navigation

import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.okproject.musicexplorer.findActivity
import com.okproject.musicexplorer.login.LoginScreen
import com.okproject.musicexplorer.spotify.SpotifyLogin.loginInBrowser

fun NavGraphBuilder.authGraph() {
    navigation<Graph.Auth>(startDestination = Screen.Login) {
        composable<Screen.Login> {
            val localActivity = LocalContext.current.findActivity()
            LoginScreen(
                onSignInButtonClicked = {
                    localActivity.loginInBrowser()
                }
            )
        }
    }
}