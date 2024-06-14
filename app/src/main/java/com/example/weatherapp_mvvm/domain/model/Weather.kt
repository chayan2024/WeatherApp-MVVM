package com.example.weatherapp_mvvm.domain.model

data class Weather(
    val id: Int,
    val userId: Int,
    val title: String,
    val body: String
)