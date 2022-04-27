package com.example.weather_test.fragments.details.view

import com.example.weather_test.domain.data.WeatherModel
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface WeatherDetailView : MvpView {

    fun onWeatherLoaded(weather: WeatherModel)

}