package com.example.weatherapp_mvvm.data.repository

import com.example.weatherapp_mvvm.data.network.ApiService
import com.example.weatherapp_mvvm.domain.model.Weather
import com.example.weatherapp_mvvm.domain.repository.WeatherRepository


class WeatherRepositoryImpl(private val apiService: ApiService) : WeatherRepository {

    override suspend fun getWeather(): List<Weather> {
        TODO("Not yet implemented")
    }
}