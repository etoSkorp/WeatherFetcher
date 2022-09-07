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
                    windSpeedInfo = "Скорость ветра: ",
                    windSpeed = temperature.wind.windSpeed,
                )
            }
            is UIEvent.OnCitySelected -> {
                return previousState.copy(
                    cityName = event.cityName
                )
            }
            is UIEvent.OnWindButtonClicked -> {
                val temperature = getWeather(previousState)
                return previousState.copy(
                    windDegInfo = "Направление ветра в городе ${previousState.cityName}: ",
                    windDeg = temperature.wind.windDeg
                )
            }
            else -> return null
        }
    }
}