package com.stu74529.movie_app

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieScreen(navController : NavController, movieName : String) {

    val movie = getMovieByName(movieName)

    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = Color.Black,
                    titleContentColor = Color(0xFFFFA500),
                ),
                title = {
                    Row(
                        Modifier
                            .clickable(onClick = {
                                navController.navigate(Routes.HomeScreen.route)
                            })
                            .background(color = Color.Black))
                    {
                        Text("< Back")
                    }
                }
            )
        },

        ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .background(Color.Black),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
        )
        {

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center

            )
            {
                Text(text = movie.name + "",
                    color = Color(0xFFFFA500),
                    fontSize = 30.sp,)
            }
            AsyncImage(modifier = Modifier
                .height(400.dp)
                .padding(50.dp,0.dp),

                model = movie.image,
                contentDescription = "Translated description of what the image contains"
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center

            )
            {
                Text(text = "Starring: ${movie.starring.joinToString()}",
                    color = Color.Gray,
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center)
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(50.dp,0.dp),
                horizontalArrangement = Arrangement.Center

            )
            {
                Text(text = "Running Time (mins): ${movie.running_time_mins}",
                    color = Color.Gray,
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center)
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center

            )
            {
                Text(text = movie.description + "",
                    color = Color.White,
                    fontSize = 17.sp,
                    textAlign = TextAlign.Center)
            }

            SeatSelectionElement(movie = movie)

        }
    }
}

val seats_remaining = mutableStateOf("")
val seats_selected = mutableStateOf("")

@Composable
fun SeatSelectionElement(movie: Movie){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ){
        Column (modifier = Modifier
            .fillMaxHeight(),
            verticalArrangement = Arrangement.Center
        )
        {
            seats_remaining.value = "Seats Remaining: ${movie.seats_remaining}";
            seats_selected.value = "Seats Remaining: ${movie.seats_selected}";

            Text(text = seats_remaining.value,
                color = Color(0xFFFFA500),
                fontSize = 17.sp,
                textAlign = TextAlign.Center)
            Text(text = seats_selected.value,
                color = Color(0xFFFFA500),
                fontSize = 17.sp,
                textAlign = TextAlign.Center)
        }
        Column (modifier = Modifier
            .fillMaxHeight(),
            verticalArrangement = Arrangement.Center
        )
        {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ){
                AsyncImage(modifier = Modifier
                    .height(50.dp)
                    .clickable(onClick = {
                        addSeat(movie)
                    }),
                    model = "https://img.icons8.com/ios/50/FFFFFF/plus--v1.png",
                    contentDescription = "Translated description of what the image contains"
                )
                AsyncImage(modifier = Modifier
                    .height(50.dp),
                    model = "https://img.icons8.com/dotty/80/FFFFFF/aircraft-seat-middle.png",
                    contentDescription = "Translated description of what the image contains"
                )
                AsyncImage(modifier = Modifier
                    .height(50.dp)
                    .clickable(onClick = {
                        removeSeat(movie)
                    }),
                    model = "https://img.icons8.com/ios/50/FFFFFF/minus.png",
                    contentDescription = "Translated description of what the image contains"
                )
            }
        }

    }
}

fun addSeat(movie:Movie){
    if(movie.seats_remaining>0){
        movie.seats_selected += 1
        movie.seats_remaining -= 1

        seats_remaining.value = "Seats Remaining: ${movie.seats_remaining}";
        seats_selected.value = "Seats Remaining: ${movie.seats_selected}";
    }
}

fun removeSeat(movie:Movie){
    if(movie.seats_selected>0){
        movie.seats_selected -= 1
        movie.seats_remaining += 1

        seats_remaining.value = "Seats Remaining: ${movie.seats_remaining}";
        seats_selected.value = "Seats Remaining: ${movie.seats_selected}";
    }
}

fun getMovieByName(movieName: String): Movie {
    return when (movieName) {
        MovieList.lordOfTheRings.name -> MovieList.lordOfTheRings
        MovieList.fightClub.name -> MovieList.fightClub
        MovieList.seven.name -> MovieList.seven
        MovieList.pulpFiction.name -> MovieList.pulpFiction
        else -> MovieList.lordOfTheRings
    }
}
