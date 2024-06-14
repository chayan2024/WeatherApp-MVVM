package com.example.weatherapp_mvvm.domain.use_cases

import com.example.weatherapp_mvvm.domain.model.Weather
import com.example.weatherapp_mvvm.domain.repository.WeatherRepository

class GetWeatherUseCase(private val weatherRepository: WeatherRepository) {
    suspend operator fun invoke(): List<Weather> {
        return weatherRepository.getWeather()
    }
}