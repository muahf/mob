package com.example.myapplication.AppNavigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.AppNavigation.MainAppScaffold
import com.example.myapplication.Screen.DetailsScreen
import com.example.myapplication.Screen.HomeScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    MainAppScaffold(navController = navController) { padding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(padding)
        ) {
            composable(route = Screen.Home.route) {
                HomeScreen(
                    onOpenDetails = {
                        navController.navigate(Screen.Details.route)
                    }
                )
            }
            composable(Screen.Details.route) {
                DetailsScreen(
                    onBackClick = { navController.popBackStack() }
                )
            }
            composable(Screen.Calendar.route) {
                HomeScreen(onOpenDetails = {})
            }
            composable(Screen.Search.route) {
                HomeScreen(onOpenDetails = {})
            }
            composable(Screen.Messages.route) {
                HomeScreen(onOpenDetails = {})
            }
            composable(Screen.Profile.route) {
                HomeScreen(onOpenDetails = {})
            }
        }
    }
}