package com.example.weatherfetcher.feature.weather_screen.data

import com.example.weatherfetcher.feature.weather_screen.data.model.WeatherRemoteModel

class WeatherRemoteSource(private val api: WeatherApi) {

    suspend fun getWeather(cityName: String): WeatherRemoteModel {
        return api.getWeather(city = cityName)
    }
}