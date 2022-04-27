package com.example.weather_test.domain.repository

import com.example.weather_test.domain.data.WeatherModel

interface IWeatherRepository {

    fun loadWeathers(forceUpdate: Boolean, callback: LoadWeatherCallback)

    interface LoadWeatherCallback {
        fun onWeatherLoaded(loadedWeatherList: List<WeatherModel>)
        fun onWeatherNotAvailable()
    }
    }
