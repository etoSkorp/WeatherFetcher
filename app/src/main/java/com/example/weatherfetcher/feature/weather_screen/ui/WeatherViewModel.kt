package com.example.weatherfetcher.feature.weather_screen.ui

import com.example.weatherfetcher.base.BaseViewModel
import com.example.weatherfetcher.base.Event
import com.example.weatherfetcher.feature.weather_screen.WeatherInteractor

class WeatherViewModel(val interactor: WeatherInteractor) : BaseViewModel<ViewState>() {

    suspend fun getWeather(): String {
        return interactor.getWeather()
    }

    suspend fun getWindDeg(): String {
        return interactor.getWindDeg()
    }

    suspend fun getWindSpeed(): String {
        return interactor.getWindSpeed()
    }

    override fun initialViewState(): ViewState =
        ViewState(
            title = "Click the button below to get temperature info",
            temperature = "",
            windDegInfo = "",
            windDeg = "",
            windSpeedInfo = "",
            windSpeed = ""
        )

    override suspend fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is UIEvent.OnButtonClicked -> {
                val temperature = getWeather()
                val windDeg = getWindDeg()
                val windSpeed = getWindSpeed()
                return previousState.copy(
                    title = "Температура: ",
                    temperature = temperature,
                    windDeg = windDeg,
                    windDegInfo = "Направление ветра: ",
                    windSpeedInfo = "Скорость ветра: ",
                    windSpeed = windSpeed
                )
            }
            else -> return null
        }
    }
}