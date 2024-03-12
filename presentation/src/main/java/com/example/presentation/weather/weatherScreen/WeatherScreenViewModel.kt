package com.example.presentation.weather.weatherScreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.openweather.WeatherData
import com.example.domain.usecase.openweather.FetchWeatherByCityUseCase
import com.example.presentation.utils.executeResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.roundToInt

@HiltViewModel
class WeatherScreenViewModel @Inject constructor(
    private val fetchWeatherByCityUseCase: FetchWeatherByCityUseCase
) : ViewModel() {

    private val _weatherData = MutableStateFlow<WeatherUIModel?>(null)
    val weatherData = _weatherData.asStateFlow()

    fun citySelect(event: WeatherScreenEvent) {
        viewModelScope.launch {
            when(event){
                is WeatherScreenEvent.CitySelect -> {
                    fetchWeatherData(event.city)
                }
                else -> {
                    //todo else event
                }
            }
        }
    }

    private suspend fun fetchWeatherData(city: String) = viewModelScope.launch(Dispatchers.IO) {
        fetchWeatherByCityUseCase(FetchWeatherByCityUseCase.Param(city)).executeResult(
            onSuccess = {
                _weatherData.value = weatherDataMapper(it)
            },
            onError = {
                Log.e("sjh"," fetchWeatherData Error ${it?.message}")
            }
        )
    }

    private fun weatherDataMapper(weatherData: WeatherData): WeatherUIModel {
        val main = WeatherUIModel.Main(
            humidity = weatherData.main?.humidity?:0,
            pressure = weatherData.main?.pressure?:0,
            temp = celsiusConversion(weatherData.main?.temp?:0.0),
            tempMax = celsiusConversion(weatherData.main?.tempMax?:0.0),
            tempMin = celsiusConversion(weatherData.main?.tempMin?:0.0)
        )
        val weatherList = weatherData.weather?.map {
            WeatherUIModel.Weather(
                description = it?.description?:"",
                icon = it?.icon?:"",
                main = it?.main,
            )
        }

        return WeatherUIModel(main = main, name = weatherData.name, weather = weatherList)
    }

    private fun celsiusConversion(temp : Double): Double{
        val kelvinTemp = 279.81
        return (kelvinTemp - temp).roundToInt().toDouble()
    }
}