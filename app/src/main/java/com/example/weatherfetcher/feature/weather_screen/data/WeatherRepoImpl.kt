package com.example.weatherfetcher.feature.weather_screen.data

class WeatherRepoImpl(private val weatherRemoteSource: WeatherRemoteSource) : WeatherRepo {

    override suspend fun getTemperature(): String {
        return weatherRemoteSource.getWeather().mainTemp.temperature
    }

    override suspend fun getWindDeg(): String {
        return weatherRemoteSource.getWeather().wind.windDeg
    }

    override suspend fun getWindSpeed(): String {
        return weatherRemoteSource.getWeather().wind.windSpeed
    }

}