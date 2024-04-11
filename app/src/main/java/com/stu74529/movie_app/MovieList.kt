package com.stu74529.movie_app

import kotlin.random.Random

sealed class MovieList(val route: String) {

    object lordOfTheRings : Movie(
    name = "Lord Of The Rings",
    image = "https://upload.wikimedia.org/wikipedia/en/4/48/Lord_Rings_Return_King.jpg",
    certification = "PG-13",
    description = "A young hobbit, Frodo, who has found the One Ring that belongs to the Dark Lord Sauron, begins his journey with eight companions to Mount Doom, the only place where it can be destroyed.",
    starring = arrayOf("Elijah Wood", "Ian McKellen", "Viggo Mortensen"),
    running_time_mins = 178,
    seats_remaining = Random.nextInt(0, 16),
    seats_selected = 0
    )

    object fightClub : Movie(
    name = "Fight Club",
    image = "https://upload.wikimedia.org/wikipedia/en/f/fc/Fight_Club_poster.jpg",
    certification = "R",
    description = "An insomniac office worker and a devil-may-care soapmaker form an underground fight club that evolves into something much, much more.",
    starring = arrayOf("Brad Pitt", "Edward Norton", "Helena Bonham Carter"),
    running_time_mins = 139,
    seats_remaining = Random.nextInt(0, 16),
    seats_selected = 0
    )

    object seven : Movie(
        name = "Seven",
        image = "https://upload.wikimedia.org/wikipedia/en/6/68/Seven_%28movie%29_poster.jpg",
        certification = "R",
        description = "Two detectives, a rookie and a veteran, hunt a serial killer who uses the seven deadly sins as his motives.",
        starring = arrayOf("Morgan Freeman", "Brad Pixtt", "Kevin Spacey"),
        running_time_mins = 127,
        seats_remaining = Random.nextInt(0, 16),
        seats_selected = 0
    )

    object pulpFiction : Movie(
        name = "Pulp Fiction",
        image = "https://upload.wikimedia.org/wikipedia/en/3/3b/Pulp_Fiction_%281994%29_poster.jpg",
        certification = "R",
        description = "The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of diner bandits intertwine in four tales of violence and redemption.",
        starring = arrayOf("John Travolta", "Uma Thurman", "Samuel L. Jackson"),
        running_time_mins = 154,
        seats_remaining = Random.nextInt(0, 16),
        seats_selected = 0
    )
}