package com.example.weatherfetcher.feature.weather_screen.data

class WeatherRepoImpl(private val weatherRemoteSource: WeatherRemoteSource) : WeatherRepo {

    override suspend fun getTemperature(cityName: String): String {
        return weatherRemoteSource.getWeather(cityName).mainTemp.temperature
    }

    override suspend fun getWindDeg(cityName: String): String {
        return weatherRemoteSource.getWeather(cityName).wind.windDeg
    }

    override suspend fun getWindSpeed(cityName: String): String {
        return weatherRemoteSource.getWeather(cityName).wind.windSpeed
    }

}