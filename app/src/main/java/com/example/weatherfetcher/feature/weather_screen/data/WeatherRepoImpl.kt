package com.example.weatherfetcher.feature.weather_screen.data

import com.example.weatherfetcher.feature.weather_screen.data.model.WeatherRemoteModel

class WeatherRepoImpl(private val weatherRemoteSource: WeatherRemoteSource) : WeatherRepo {

    override suspend fun getWeather(cityName: String): WeatherRemoteModel {
        return weatherRemoteSource.getWeather(cityName)
    }
}