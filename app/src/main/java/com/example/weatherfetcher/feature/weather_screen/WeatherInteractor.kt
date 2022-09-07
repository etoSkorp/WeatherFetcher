package com.example.weatherfetcher.feature.weather_screen

import com.example.weatherfetcher.feature.weather_screen.data.WeatherRepo
import com.example.weatherfetcher.feature.weather_screen.data.model.WeatherRemoteModel

class WeatherInteractor(private val weatherRepo: WeatherRepo) {

    suspend fun getWeather(cityName: String): WeatherRemoteModel {
        return weatherRepo.getWeather(cityName)
    }
}