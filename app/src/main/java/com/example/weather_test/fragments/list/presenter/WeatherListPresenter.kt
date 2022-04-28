package com.example.weather_test.fragments.list.presenter

import com.example.weather_test.R
import com.example.weather_test.domain.repository.IWeatherRepository
import com.example.weather_test.models.WeatherModel
import com.example.weather_test.fragments.list.view.WeatherListView
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