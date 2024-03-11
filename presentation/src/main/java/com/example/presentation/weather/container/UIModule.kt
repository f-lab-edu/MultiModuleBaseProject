package com.example.presentation.weather.container

import com.example.domain.container.DomainModule
import com.example.presentation.weather.weatherScreenxml.WeatherScreenWithoutHiltViewModel

object UIModule{
    val weatherScreenViewModel: WeatherScreenWithoutHiltViewModel by lazy {
        WeatherScreenWithoutHiltViewModel(DomainModule.fetchWeatherByCityUseCase)
    }
}