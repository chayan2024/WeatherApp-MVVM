package com.example.weatherapp_mvvm.data.network


<<<<<<< HEAD
import com.example.weatherapp_mvvm.model.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("weather")
    fun getWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("exclude") exclude: String,
        @Query("appid") appid: String
    ): Call<WeatherResponse>
=======
import com.example.weatherapp_mvvm.model.Weather
import retrofit2.http.GET

interface ApiService {
    @GET("Weather")
    suspend fun getWeather(): List<Weather>
>>>>>>> main
}