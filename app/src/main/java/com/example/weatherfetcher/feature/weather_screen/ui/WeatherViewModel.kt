package com.example.weatherfetcher.feature.weather_screen.ui

import com.example.weatherfetcher.base.BaseViewModel
import com.example.weatherfetcher.base.Event
import com.example.weatherfetcher.feature.weather_screen.WeatherInteractor

class WeatherViewModel(val interactor: WeatherInteractor) : BaseViewModel<ViewState>() {

    suspend fun getWeather(previousState: ViewState): String {
        return interactor.getWeather(previousState.cityName)
    }

    suspend fun getWindDeg(previousState: ViewState): String {
        return interactor.getWindDeg(previousState.cityName)
    }

    suspend fun getWindSpeed(previousState: ViewState): String {
        return interactor.getWindSpeed(previousState.cityName)
    }

    override fun initialViewState(): ViewState =
        ViewState(
            title = "Click the button below to get temperature info",
            temperature = "",
            windDegInfo = "",
            windDeg = "",
            windSpeedInfo = "",
            windSpeed = "",
            cityName = "Moscow"
        )

    override suspend fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is UIEvent.OnButtonClicked -> {
                val temperature = getWeather(previousState)
                val windDeg = getWindDeg(previousState)
                val windSpeed = getWindSpeed(previousState)
                return previousState.copy(
                    title = "Температура: ",
                    temperature = temperature,
                    windDeg = windDeg,
                    windDegInfo = "Направление ветра: ",
                    windSpeedInfo = "Скорость ветра: ",
                    windSpeed = windSpeed,
                    cityName = previousState.cityName
                )
            }
            is UIEvent.OnCitySelected -> {
                return previousState.copy(
                    cityName = event.cityName
                )
            }
            else -> return null
        }
    }
}