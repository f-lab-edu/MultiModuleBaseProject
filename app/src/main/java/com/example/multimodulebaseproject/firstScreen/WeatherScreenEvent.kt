package com.example.multimodulebaseproject.firstScreen

sealed class WeatherScreenEvent{
    data class CitySelect(val city: String) : WeatherScreenEvent()
}