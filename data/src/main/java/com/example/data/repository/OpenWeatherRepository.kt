package com.example.data.repository

import com.example.data.model.openweather.WeatherResponse
//import com.example.data.model.openweather.WeatherResponseDTO
//import com.example.domain.model.openweather.WeatherData

// TODO. functional interface https://bcp0109.tistory.com/313
interface OpenWeatherRepository {
    suspend fun fetchWeatherByCity(city:String) : WeatherResponse
}