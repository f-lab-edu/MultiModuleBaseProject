package com.example.presentation.weather.firstScreen

sealed class WeatherScreenEvent{
    data class CitySelect(val city: String) : WeatherScreenEvent()
}