package com.example.domain.model.openweather


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherData(
    @SerialName("main")
    val main: Main,

    @SerialName("name")
    val name: String,

    @SerialName("weather")
    val weather: List<Weather>,
//    @SerialName("base")
//    val base: String,
//
//    @SerialName("cod")
//    val cod: Int,
//
//    @SerialName("coord")
//    val coord: Coord,
//
//    @SerialName("dt")
//    val dt: Int,
//
//    @SerialName("id")
//    val id: Int,
//    @SerialName("visibility")
//    val visibility: Int,

//    @SerialName("sys")
//    val sys: Sys,
//    @SerialName("clouds")
//    val clouds: Clouds,
//    @SerialName("wind")
//    val wind: Wind
) {
    @Serializable
    data class Main(
        @SerialName("humidity")
        val humidity: Int,
        @SerialName("pressure")
        val pressure: Int,
        @SerialName("temp")
        val temp: Double,
        @SerialName("temp_max")
        val tempMax: Double,
        @SerialName("temp_min")
        val tempMin: Double
    )
    @Serializable
    data class Weather(
        @SerialName("description")
        val description: String,
        @SerialName("icon")
        val icon: String,
        @SerialName("id")
        val id: Int,
        @SerialName("main")
        val main: String
    )
//    @Serializable
//    data class Coord(
//        @SerialName("lat")
//        val lat: Double,
//        @SerialName("lon")
//        val lon: Double
//    )
//    @Serializable
//    data class Clouds(
//        @SerialName("all")
//        val all: Int
//    )


//    @Serializable
//    data class Sys(
//        @SerialName("country")
//        val country: String,
//        @SerialName("id")
//        val id: Int,
//        @SerialName("message")
//        val message: Double,
//        @SerialName("sunrise")
//        val sunrise: Int,
//        @SerialName("sunset")
//        val sunset: Int,
//        @SerialName("type")
//        val type: Int
//    )


//    @Serializable
//    data class Wind(
//        @SerialName("deg")
//        val deg: Int,
//        @SerialName("speed")
//        val speed: Double
//    )
}