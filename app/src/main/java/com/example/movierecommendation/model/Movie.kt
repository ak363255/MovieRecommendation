package com.example.movierecommendation.model

data class Movie(
    val id:String = "0",
    val movieName: String = "Iron Man",
    val rating: Float = 4.5F,
    val description: String = "",
    val duration:String = "40 min",
    val starsName:List<String> = listOf(),
    val noOfVotes:String = "123",
    val viewType:String = "movie_view"
)