package com.example.weatherapp_mvvm.data.network


import com.example.weatherapp_mvvm.model.Weather
import retrofit2.http.GET

interface ApiService {
    @GET("weather")
    fun getWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("exclude") exclude: String,
        @Query("appid") appid: String
    ): Call<WeatherResponse>
}