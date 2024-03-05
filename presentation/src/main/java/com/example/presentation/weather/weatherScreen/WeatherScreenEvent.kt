package com.example.presentation.weather.weatherScreen

sealed class WeatherScreenEvent{
    data class CitySelect(val city: String) : WeatherScreenEvent()
}