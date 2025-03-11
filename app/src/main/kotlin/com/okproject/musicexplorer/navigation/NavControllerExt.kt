package com.okproject.musicexplorer.navigation

import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hasRoute

fun NavController.isCurrentRoute(route: Any): Boolean =
    this.currentDestination?.hasRoute(route::class) == true

