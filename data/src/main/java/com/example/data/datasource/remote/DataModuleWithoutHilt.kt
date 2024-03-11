package com.example.data.datasource.remote

import com.example.data.api.OpenWeatherAPI
import com.example.data.model.openweather.WeatherResponse
import com.example.data.repository.OpenWeatherRepository
import com.example.data.repository.OpenWeatherRepositoryImpl
import com.example.data.repository.OpenWeatherRepositoryWithoutHiltImpl
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DataModuleWithoutHilt {

    private inline fun <reified T : Any> createApi(url: String, ): T {
        return Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(T::class.java)
    }

    private val weatherApiService: OpenWeatherAPI by lazy { createApi("https://api.openweathermap.org") }

    val weatherRepository : OpenWeatherRepositoryWithoutHiltImpl by lazy { OpenWeatherRepositoryWithoutHiltImpl(weatherApiService) }

}