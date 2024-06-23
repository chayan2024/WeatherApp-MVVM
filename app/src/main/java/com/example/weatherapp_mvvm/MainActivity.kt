package com.example.weatherapp_mvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.weatherapp_mvvm.model.WeatherResponse
import com.example.weatherapp_mvvm.ui.theme.WeatherAppMVVMTheme
import com.example.weatherapp_mvvm.viewmodel.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppMVVMTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    WeatherScreen()
                }
            }
        }
    }
}

@Composable
fun WeatherScreen(viewModel: WeatherViewModel = hiltViewModel()) {
    val latitude = 41.414116
    val longitude = -73.303566
    val exclude = "part"
    val appid = "c9085a65eba47dfc2f82d0f842d778de"

    val weatherResponse by viewModel.weatherResponse.observeAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchWeather(latitude, longitude, exclude, appid)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (weatherResponse != null) {
            WeatherInfo(weatherResponse!!)
        } else {
            Text("Loading...", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        }
    }
}
@Composable
fun WeatherInfo(weather: WeatherResponse) {
    val weatherIconUrl = "https://openweathermap.org/img/wn/${weather.weather[0].icon}@2x.png"

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = weather.name,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Text(
            text = "${weather.main.temp}°C",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = weather.weather[0].description,
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center
        )

        Text(
            text = weather.weather[0].icon,
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WeatherAppMVVMTheme {

    }
}