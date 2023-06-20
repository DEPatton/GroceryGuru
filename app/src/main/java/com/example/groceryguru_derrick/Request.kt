package com.example.groceryguru_derrick

//API Documentation Website = https://developer.edamam.com/edamam-docs-recipe-api

class Request(
    var type: String,
    var q: String,
    var app_id: String? = "4c31632c",
    var app_key: String? = "8e5100d3f2a340331004a4dd3f87fdca",
    var ingr: String,
    var diet: String,
    var cuisineType: String,
    var mealType: String,
    var time: String,
    var imageSize: String? = "THUMBNAIL",
    //var random: Boolean, //To be implemented later.
)