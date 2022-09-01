package com.example.weatherfetcher.feature.weather_screen.data.model

import com.google.gson.annotations.SerializedName

data class WeatherRemoteModel(
    @SerializedName("main")
    val mainTemp: WeatherMainRemoteModel,
    @SerializedName("wind")
    val wind: WeatherWindRemoteModel
)
