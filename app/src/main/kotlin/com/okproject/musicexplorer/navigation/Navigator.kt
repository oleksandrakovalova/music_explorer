package com.okproject.musicexplorer.navigation

import androidx.navigation.NavController

object Navigator {
    fun NavController.navigateToAuthRoute() {
        this.navigate(Graph.Auth) {
            popUpTo(Graph.Root) {
                inclusive = true
            }
        }
    }

    // TODO check navigation with unauth error during requests
    fun NavController.navigateToMainRoute() {
        if (this.isCurrentRoute(Screen.Login)) {
            this.navigate(Graph.Main) {
                popUpTo(Graph.Auth) {
                    inclusive = true
                }
            }
        } else {
            this.navigate(Graph.Main) {
                popUpTo(Graph.Root) {
                    inclusive = true
                }
            }
        }
    }
}