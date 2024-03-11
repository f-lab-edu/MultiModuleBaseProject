package com.example.domain.usecase.openweather

import com.example.data.repository.OpenWeatherRepository
import com.example.domain.model.openweather.WeatherData
import com.example.domain.model.openweather.toDomain
import com.example.domain.usecase.utils.UseCase

class FetchWeatherByCityWithoutHiltUseCase(
    private val repository: OpenWeatherRepository
) : UseCase<String, WeatherData>() {
    override suspend fun execute(param: String): WeatherData {
        return repository.fetchWeatherByCity(param).toDomain()
    }
}