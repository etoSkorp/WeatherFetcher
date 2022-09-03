package com.example.weatherfetcher.feature.weather_screen

import com.example.weatherfetcher.feature.weather_screen.data.WeatherRepo

class WeatherInteractor(private val weatherRepo: WeatherRepo) {

    suspend fun getWeather(cityName: String): String {
        return weatherRepo.getTemperature(cityName)
    }

    suspend fun getWindDeg(cityName: String): String {
        return weatherRepo.getWindDeg(cityName)
    }

    suspend fun getWindSpeed(cityName: String): String {
        return weatherRepo.getWindSpeed(cityName)
    }
}