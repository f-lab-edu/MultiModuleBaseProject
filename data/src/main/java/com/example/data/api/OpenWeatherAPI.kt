package com.example.data.api

import com.example.data.model.openweather.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface OpenWeatherAPI {
    @GET("/data/2.5/weather")
    suspend fun fetchWeatherByLatLng(
        @Query("lat") lat: Double,
        @Query("lng") lng: Double,
        @Query("appid") appid: String
    ): WeatherResponse

    @GET("/data/2.5/weather")
    suspend fun fetchWeatherByCountry(
        @Query("q") cityName: String,
        @Query("appid") appid: String
    ): WeatherResponse
}