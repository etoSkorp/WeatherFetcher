package com.example.weatherfetcher.feature.weather_screen.data

interface WeatherRepo {
    suspend fun getTemperature(cityName: String): String
    suspend fun getWindDeg(cityName: String): String
    suspend fun getWindSpeed(cityName: String): String
}