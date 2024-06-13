package com.example.weatherapp_mvvm.data.network


import com.example.weatherapp_mvvm.model.Weather
import retrofit2.http.GET

interface ApiService {
    @GET("Weather")
    suspend fun getPosts(): List<Weather>
}