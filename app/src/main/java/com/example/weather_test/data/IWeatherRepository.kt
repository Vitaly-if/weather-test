package com.example.weather_test.data

import com.example.weather_test.data.models.WeatherModel

interface IWeatherRepository {

    fun loadWeathers(forceUpdate: Boolean, callback: LoadWeatherCallback)

    //fun loadMovie(callback: LoadMovieCallback)

    interface LoadWeatherCallback {
        fun onWeatherLoaded(loadedWeatherList: List<WeatherModel>)
        fun onWeatherNotAvailable()
    }
    }
