package com.example.data.repository

import com.example.data.api.OpenWeatherAPI
import com.example.data.model.openweather.toDomain
import com.example.domain.model.openweather.WeatherData
import com.example.domain.repository.OpenWeatherRepository
import javax.inject.Inject
import javax.inject.Named
class OpenWeatherRepositoryImpl @Inject constructor(
    @Named("API_OPEN_WEATHER")
    private val api: OpenWeatherAPI
) : OpenWeatherRepository {

    override suspend fun fetchWeatherByCity(city: String): WeatherData {
        return api.fetchWeatherByCountry(city,"BuildConfig.openWeatherKey").toDomain()
    }
}