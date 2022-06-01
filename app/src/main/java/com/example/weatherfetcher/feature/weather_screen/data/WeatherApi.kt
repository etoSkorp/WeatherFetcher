package com.example.weatherfetcher.feature.weather_screen.data

import com.example.weatherfetcher.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("weather")
    fun getWeather(
        @Query("q") q: String,
        @Query("appid") apiKey: String = API_KEY
    ): Response<String>
}