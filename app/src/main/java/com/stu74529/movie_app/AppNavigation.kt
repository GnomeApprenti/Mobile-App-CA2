package com.stu74529.movie_app

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.HomeScreen.route,
    ) {
        composable(route = Routes.HomeScreen.route)
        {
            HomeScreen(navController = navController)
        }
        composable(route = Routes.MovieScreen.route + "/{movieName}",
            arguments = listOf(
                navArgument("movieName"){
                    type = NavType.StringType
                    defaultValue = ""
                }
            )){ entry ->
            entry.arguments?.let { MovieScreen(movieName = "" + it.getString("movieName"),navController = navController) }
        }
    }
}