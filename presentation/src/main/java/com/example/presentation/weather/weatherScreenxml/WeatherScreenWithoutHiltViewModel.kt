package com.example.presentation.weather.weatherScreenxml

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.openweather.WeatherData
import com.example.domain.usecase.openweather.FetchWeatherByCityWithoutHiltUseCase
import com.example.domain.usecase.utils.successOr
import kotlinx.coroutines.launch
import timber.log.Timber

class WeatherScreenWithoutHiltViewModel(
    private val fetchWeatherByCityWithoutHiltUseCase: FetchWeatherByCityWithoutHiltUseCase
) : ViewModel() {

    private val _weatherData = MutableLiveData<WeatherData>()
    val weatherData :LiveData<WeatherData> = _weatherData

    val cities = listOf("London", "Seoul", "Tokyo", "Busan")

    fun fetchWeather(city:String){
        viewModelScope.launch {
            _weatherData.value = fetchWeatherByCityWithoutHiltUseCase(city).successOr(null)
            Timber.d("data = ${weatherData.value}")
        }
    }

}