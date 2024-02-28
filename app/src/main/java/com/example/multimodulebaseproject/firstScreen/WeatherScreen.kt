package com.example.multimodulebaseproject.firstScreen

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun WeatherScreen(viewModel: WeatherScreenViewModel) {

    val cities = listOf("London", "Seoul", "Tokyo", "Busan")
    // DropDown Menu 열림 상태
    var isDropDownMenuExpanded by remember { mutableStateOf(false) }
    val selectedCity = viewModel.weatherData.collectAsState().value
    Row{
        Column {
            Button(onClick = { isDropDownMenuExpanded = true }) {
                Text(text = "도시 선택")
            }
            DropdownMenu(
                expanded = isDropDownMenuExpanded,
                onDismissRequest = { isDropDownMenuExpanded = false },
                modifier = Modifier
                    .padding(20.dp)
                    .wrapContentSize()
            ) {
                cities.forEach { city ->
                    DropdownMenuItem(
                        text = { Text(text = city) },
                        onClick = {
                            viewModel.citySelect(WeatherScreenEvent.CitySelect(city))
                            isDropDownMenuExpanded = false
                        })
                }
            }
        }

        if (selectedCity != null) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text(text = "도시 이름 = ${selectedCity.name}")
                Text(text = "습도 = ${selectedCity.main.humidity}%")
                Text(text = "온도 = ${selectedCity.main.temp}")
                Text(text = "날씨 = ${selectedCity.weather.first().main}")
            }
        }
    }

}

@Preview
@Composable
fun prev() {
    val cities = listOf("London", "Seoul", "Tokyo", "Busan")
    var isDropDownMenuExpanded by remember { mutableStateOf(false) }

    Column {
        Button(onClick = { isDropDownMenuExpanded = true }) {
            Text(text = "도시 선택")
        }
        DropdownMenu(
            expanded = isDropDownMenuExpanded,
            onDismissRequest = { isDropDownMenuExpanded = false },
            modifier = Modifier
                .wrapContentSize()
        ) {
            cities.forEach { city ->
                DropdownMenuItem(
                    text = {  Text(text = city) },
                    modifier = Modifier.wrapContentSize(),
                    onClick = {
                        Log.d("sjh","clicked City$city")
                        isDropDownMenuExpanded = false
                    })
            }
        }
    }
}