package com.example.presentation.weather.weatherScreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.presentation.weather.theme.MultiModuleBaseProjectTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeatherScreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: WeatherScreenViewModel = hiltViewModel()

            MultiModuleBaseProjectTheme {
                WeatherScreen(viewModel = viewModel)
            }
        }
    }
}