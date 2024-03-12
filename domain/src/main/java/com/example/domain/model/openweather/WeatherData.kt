package com.example.domain.model.openweather


import com.example.data.model.openweather.WeatherResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// TODO. 서버에서 null로 주면 어떻게 되나? 해결할려면? Primitive Type vs Reference Type
@Serializable
data class WeatherData(
    @SerialName("main")
    val main: Main?,

    @SerialName("name")
    val name: String?,

    @SerialName("weather")
    val weather: List<Weather?>?,
) {
    @Serializable
    data class Main(
        @SerialName("humidity")
        val humidity: Int?,
        @SerialName("pressure")
        val pressure: Int?,
        @SerialName("temp")
        val temp: Double?,
        @SerialName("temp_max")
        val tempMax: Double?,
        @SerialName("temp_min")
        val tempMin: Double?
    )

    @Serializable
    data class Weather(
        @SerialName("description")
        val description: String?,
        @SerialName("icon")
        val icon: String?,
        @SerialName("id")
        val id: Int?,
        @SerialName("main")
        val main: String?
    )
}

internal fun WeatherResponse.toDomain() = WeatherData(
    name = name,
    main = main.toDomain(),
    weather = weather.map { it.toDomain() }
)

private fun WeatherResponse.Main.toDomain() = WeatherData.Main(
    humidity = humidity,
    pressure = pressure,
    temp = temp,
    tempMax = tempMax,
    tempMin = tempMin
)

private fun WeatherResponse.Weather.toDomain() = WeatherData.Weather(
    description = description,
    icon = icon,
    id = id,
    main = main
)