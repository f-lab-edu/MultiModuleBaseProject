package com.example.multimodulebaseproject

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.openweather.FetchWeatherByCityUseCase
import com.example.domain.usecase.utils.successOr
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val openWeatherByCityUseCase: FetchWeatherByCityUseCase
) : ViewModel() {
    init {
        viewModelScope.launch {
            val city: String = "seoul"
            val result =
                openWeatherByCityUseCase(FetchWeatherByCityUseCase.Param(city)).successOr(null)

            Log.d("sjh", "api result $result")
        }
    }
}