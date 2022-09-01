package com.example.weatherfetcher.feature.weather_screen

import com.example.weatherfetcher.feature.weather_screen.data.WeatherRepo

class WeatherInteractor(private val weatherRepo: WeatherRepo) {

    suspend fun getWeather(): String {
        return weatherRepo.getTemperature()
    }

    suspend fun getWindDeg(): String {
        return weatherRepo.getWindDeg()
    }

    suspend fun getWindSpeed(): String {
        return weatherRepo.getWindSpeed()
    }
}