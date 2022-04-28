package com.example.weather_test.fragments.details.presenter

import com.example.weather_test.models.WeatherModel
import com.example.weather_test.fragments.details.view.WeatherDetailView
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class WeatherDetailPresenter(private val selectWeather: WeatherModel) : MvpPresenter<WeatherDetailView>() {


    lateinit var weather: WeatherModel

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadWeather()
    }

    private fun loadWeather() {
        weather = selectWeather

        viewState.showWeather(weather)
    }

}

