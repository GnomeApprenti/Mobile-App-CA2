package com.stu74529.movie_app

public open class Movie(
    var name: String,
    var image: String,
    var certification: String,
    var description: String,
    var starring: Array<String>,
    var running_time_mins: Int,
    var seats_remaining: Int,
    var seats_selected: Int
) {

}