package com.example.presentation.weather.weatherScreen

data class WeatherUIModel(
    val main: Main?,

    val name: String?,

    val weather: List<Weather?>?,
) {
    data class Main(
        val humidity: Int?, // 습도
        val pressure: Int?, // 해수면 기압
        val temp: Double?, // 온도
        val tempMax: Double?, // 최대 기온
        val tempMin: Double?, // 최저 기온
    )

    data class Weather(
        val description: String?,
        val icon: String?,
        val main: String?
    )
}
