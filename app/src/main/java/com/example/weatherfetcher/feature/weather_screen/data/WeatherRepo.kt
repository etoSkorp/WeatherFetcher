package com.example.weatherfetcher.feature.weather_screen.data

import com.example.weatherfetcher.feature.weather_screen.data.model.WeatherRemoteModel

interface WeatherRepo {
    suspend fun getWeather(cityName: String): WeatherRemoteModel
//    suspend fun getWindDeg(cityName: String): String
//    suspend fun getWindSpeed(cityName: String): String
}