package com.example.weatherfetcher.feature.weather_screen.ui

import com.example.weatherfetcher.base.BaseViewModel
import com.example.weatherfetcher.base.Event
import com.example.weatherfetcher.feature.weather_screen.WeatherInteractor
import com.example.weatherfetcher.feature.weather_screen.data.model.WeatherRemoteModel

class WeatherViewModel(private val interactor: WeatherInteractor) : BaseViewModel<ViewState>() {

    private suspend fun getWeather(previousState: ViewState): WeatherRemoteModel {
        return interactor.getWeather(previousState.cityName)
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
                return previousState.copy(
                    title = "Температура: ",
                    temperature = temperature.mainTemp.temperature,
                    windDeg = temperature.wind.windDeg,
                    windDegInfo = "Направление ветра: ",
                    windSpeedInfo = "Скорость ветра: ",
                    windSpeed = temperature.wind.windSpeed,
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