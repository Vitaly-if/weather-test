package com.example.weather_test.mvp.view

import com.example.weather_test.data.models.WeatherModel
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface WeatherDetailView : MvpView {

    fun onWeatherLoaded(weather: WeatherModel)

}