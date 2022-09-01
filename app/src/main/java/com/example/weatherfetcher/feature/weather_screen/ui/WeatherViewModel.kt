package com.example.weatherfetcher.feature.weather_screen.ui

import com.example.weatherfetcher.base.BaseViewModel
import com.example.weatherfetcher.base.Event
import com.example.weatherfetcher.feature.weather_screen.WeatherInteractor

class WeatherViewModel(val interactor: WeatherInteractor) : BaseViewModel<ViewState>() {

    suspend fun getWeather(): String {
        return interactor.getWeather()
    }

    override fun initialViewState(): ViewState =
        ViewState(title = "Click the button below to get temperature info", temperature = "")

    override suspend fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is UIEvent.OnButtonClicked -> {
                val temperature = getWeather()
                return previousState.copy(title = "", temperature = temperature)
            }
            else -> return null
        }
    }
}