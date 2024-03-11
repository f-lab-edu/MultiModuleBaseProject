package com.example.domain.container

import com.example.data.datasource.remote.DataModuleWithoutHilt
import com.example.domain.usecase.openweather.FetchWeatherByCityWithoutHiltUseCase

object DomainModule {
    val fetchWeatherByCityUseCase : FetchWeatherByCityWithoutHiltUseCase by lazy {
        FetchWeatherByCityWithoutHiltUseCase(DataModuleWithoutHilt.weatherRepository)
    }
}