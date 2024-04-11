package com.stu74529.movie_app

sealed class Routes(val route: String) {
    object HomeScreen : Routes("home_screen")
    object MovieScreen : Routes("movie_screen")
}