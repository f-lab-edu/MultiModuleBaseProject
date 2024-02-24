package com.example.domain.repository

import com.example.domain.model.openweather.WeatherData

interface OpenWeatherRepository {
    suspend fun fetchWeatherByCity(city:String) : WeatherData
}