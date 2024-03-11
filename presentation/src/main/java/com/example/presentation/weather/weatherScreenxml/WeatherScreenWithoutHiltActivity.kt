package com.example.presentation.weather.weatherScreenxml

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import androidx.databinding.DataBindingUtil
import com.example.presentation.R
import com.example.presentation.databinding.ActivityWeatherScreenWithoutHiltBinding
import com.example.presentation.weather.container.UIModule

class WeatherScreenWithoutHiltActivity : AppCompatActivity() {

    private val viewModel : WeatherScreenWithoutHiltViewModel by lazy { UIModule.weatherScreenViewModel }
    private lateinit var binding : ActivityWeatherScreenWithoutHiltBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_weather_screen_without_hilt)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        setListener()

    }

    private fun setListener() {
        binding.citySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener,
            AdapterView.OnItemClickListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedCity = parent?.getItemAtPosition(position).toString()
                Log.d("sjh","selected = $selectedCity")

                viewModel.fetchWeather(selectedCity)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

            override fun onItemClick(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                TODO("Not yet implemented")
            }

        }
    }
}