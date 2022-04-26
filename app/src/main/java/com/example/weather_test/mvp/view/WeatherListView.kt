package com.example.weather_test.mvp.view


import com.example.weather_test.data.models.WeatherModel
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.SkipStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface WeatherListView : MvpView {

    fun onWeatherLoaded(weathers: List<WeatherModel>)

    @StateStrategyType(value = SkipStrategy::class)
    fun openWeatherDetails(weatherModel: WeatherModel)

    @StateStrategyType(value = SkipStrategy::class)
    fun showErrorMsg(msg: Int)


}