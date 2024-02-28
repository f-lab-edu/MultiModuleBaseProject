package com.example.multimodulebaseproject.firstScreen

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.multimodulebaseproject.ui.theme.MultiModuleBaseProjectTheme
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