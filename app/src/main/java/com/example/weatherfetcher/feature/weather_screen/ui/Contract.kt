package com.example.weatherfetcher.feature.weather_screen.ui

import com.example.weatherfetcher.base.Event

data class ViewState(
    val title: String,
    val temperature: String,
    val windSpeed: String,
    val windDeg: String,
    val windSpeedInfo: String,
    val windDegInfo: String
)

sealed class UIEvent : Event {
    object OnButtonClicked : UIEvent()
}