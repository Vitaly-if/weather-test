package com.example.weather_test.mvp.presenter

import com.example.weather_test.R
import com.example.weather_test.data.IWeatherRepository
import com.example.weather_test.data.models.WeatherModel
import com.example.weather_test.mvp.view.WeatherListView
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class WeatherListPresenter(private val repository: IWeatherRepository) :
    MvpPresenter<WeatherListView>() {

    private fun loadWeathers() {
        repository.loadWeathers(true, object : IWeatherRepository.LoadWeatherCallback {
            override fun onWeatherLoaded(weatherList: List<WeatherModel>) {
                viewState.onWeatherLoaded(weatherList)
            }

            override fun onWeatherNotAvailable() {
                viewState.showErrorMsg(R.string.msg_internet_error)
            }
        })
    }

    fun showDetails(weather: WeatherModel) {
        viewState.openWeatherDetails(weather)
    }

    fun reloadWeathers() {
        loadWeathers()
    }

}