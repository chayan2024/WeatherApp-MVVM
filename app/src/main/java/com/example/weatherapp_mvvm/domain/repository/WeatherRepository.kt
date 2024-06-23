package com.example.weatherapp_mvvm.domain.repository

import com.example.weatherapp_mvvm.domain.model.Weather


interface WeatherRepository {
    suspend fun getWeather(): List<Weather>
}