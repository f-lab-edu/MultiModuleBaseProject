package com.example.data.datasource.remote

import com.example.data.api.OpenWeatherAPI
import com.example.data.model.openweather.WeatherResponse
import com.example.data.repository.OpenWeatherRepository
import com.example.data.repository.OpenWeatherRepositoryImpl
import com.example.data.repository.OpenWeatherRepositoryWithoutHiltImpl
import com.facebook.flipper.plugins.network.FlipperOkhttpInterceptor
import com.facebook.flipper.plugins.network.NetworkFlipperPlugin
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DataModuleWithoutHilt {

    private var networkFlipperPlugin: NetworkFlipperPlugin = NetworkFlipperPlugin()

    val provideWeatherRepository: OpenWeatherRepositoryWithoutHiltImpl by lazy {
        OpenWeatherRepositoryWithoutHiltImpl(weatherApiService)
    }

    fun initializeNetworkFlipperPlugin(plugin: NetworkFlipperPlugin) {
        networkFlipperPlugin = plugin
    }

    private val weatherApiService: OpenWeatherAPI by lazy {
        createApi(
            url = "https://api.openweathermap.org",
            client = provideClient(networkFlipperPlugin)
        )
    }
    private fun provideClient(flipperPlugin: NetworkFlipperPlugin?): OkHttpClient {
        return OkHttpClient.Builder()
            .apply {
                HttpLoggingInterceptor().run { level = HttpLoggingInterceptor.Level.BODY }
                flipperPlugin?.let { addNetworkInterceptor(FlipperOkhttpInterceptor(flipperPlugin))}
            }.build()
    }

    private inline fun <reified T : Any> createApi(url: String, client: OkHttpClient): T {
        return Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(T::class.java)
    }

}