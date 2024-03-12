package com.example.domain.usecase.openweather

import com.example.domain.model.openweather.WeatherData
import com.example.data.repository.OpenWeatherRepository
import com.example.domain.model.openweather.toDomain
import com.example.domain.usecase.utils.UseCase
import javax.inject.Inject

class FetchWeatherByCityUseCase @Inject constructor(
    private val repository: OpenWeatherRepository,
) : UseCase<FetchWeatherByCityUseCase.Param, WeatherData>() {
    data class Param(val city: String)

    override suspend fun execute(param : Param): WeatherData {
       return repository.fetchWeatherByCity(param.city).toDomain()
    }
}