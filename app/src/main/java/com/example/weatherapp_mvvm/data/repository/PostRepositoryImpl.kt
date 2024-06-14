package com.example.weatherapp_mvvm.data.repository

import com.example.weatherapp_mvvm.data.network.ApiService
import com.example.weatherapp_mvvm.domain.model.Weather
import com.example.weatherapp_mvvm.domain.repository.WeatherRepository


class PostRepositoryImpl(private val apiService: ApiService) : WeatherRepository {
    override suspend fun getPosts(): List<Weather> {
        val postDataList: List<Weather> = apiService.getWeather()
        return postDataList.map { it.toDomainModel() }
    }
}