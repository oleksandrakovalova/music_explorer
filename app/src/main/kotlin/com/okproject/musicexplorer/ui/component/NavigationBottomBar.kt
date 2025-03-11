package com.okproject.musicexplorer.ui.component

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import com.okproject.musicexplorer.navigation.BottomNavigationRoute

@Composable
fun NavigationBottomBar(
    routes: List<BottomNavigationRoute>,
    navController: NavHostController
) {
    var selectedIndex by rememberSaveable { mutableIntStateOf(0) }
    NavigationBar {
        routes.forEachIndexed { index, route ->
            NavigationBarItem(
                selected = index == selectedIndex,
                onClick = {
                    selectedIndex = index
                    navController.navigate(route.destination)
                },
                icon = {
                    Icon(
                        route.icon,
                        contentDescription = null
                    )
                },
                label = { Text(route.title) }
            )
        }
    }
}