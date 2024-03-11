package com.example.data.repository

import com.example.data.api.OpenWeatherAPI
import com.example.data.model.openweather.WeatherResponse

class OpenWeatherRepositoryWithoutHiltImpl(
    private val api : OpenWeatherAPI
) :OpenWeatherRepository {
    override suspend fun fetchWeatherByCity(city: String): WeatherResponse {
        return api.fetchWeatherByCountry(city,"d72ec7b7f710ae389c624e2aa88d2882")
    }
}