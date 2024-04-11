package com.stu74529.movie_app

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController : NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = Color.Black,
                    titleContentColor = Color(0xFFFFA500),
                ),
                title = {
                    Text("Leith's movie app")
                }
            )
        },

        ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .background(Color.Black)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Movies(navController)
        }
    }
}

@Composable
fun Movies(navController : NavController) {
    val movieList = listOf(
        MovieList.lordOfTheRings,
        MovieList.fightClub,
        MovieList.seven,
        MovieList.pulpFiction
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(movieList.size) { index ->
            MovieItem(movie = movieList[index], navController)
        }
    }
}

@Composable
fun MovieItem(movie: Movie, navController : NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.Center

    )
    {
        Column (modifier = Modifier
            .fillMaxHeight()
            .padding(50.dp, 0.dp),
            verticalArrangement = Arrangement.Center
        )
        {
        AsyncImage(modifier = Modifier
            .height(500.dp)
            .clickable(onClick = {
                navController.navigate(Routes.MovieScreen.route +"/"+movie.name)
            }),

            model = movie.image,
            contentDescription = "Translated description of what the image contains"
        )
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center

            )
            {
                Text(text = movie.name,
                    color = Color(0xFFFFA500),
                    fontSize = 23.sp,)
            }
        }
    }
}
