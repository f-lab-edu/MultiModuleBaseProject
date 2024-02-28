package com.example.domain.repository

import com.example.domain.model.openweather.WeatherData

// TODO. functional interface https://bcp0109.tistory.com/313
interface OpenWeatherRepository {
    suspend fun fetchWeatherByCity(city:String) : WeatherData
}