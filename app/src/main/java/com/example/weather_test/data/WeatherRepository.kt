package com.example.weather_test.data

import com.example.weather_test.data.models.WeatherModel
import com.example.weather_test.data.remote.MMWEATHER
import com.example.weather_test.data.remote.WeatherApi
import com.example.weather_test.data.remote.WeatherApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherRepository : IWeatherRepository {
    override fun loadWeathers(
        forceUpdate: Boolean,
        callback: IWeatherRepository.LoadWeatherCallback
    ) {
        loadWeathersFromNetwork(callback)
    }

    private fun loadWeathersFromNetwork(callback: IWeatherRepository.LoadWeatherCallback) {
        val apiClient = WeatherApi.client.create(WeatherApiInterface::class.java)

        apiClient.getWeathers().enqueue(object : Callback<MMWEATHER> {

            override fun onResponse(call: Call<MMWEATHER>, response: Response<MMWEATHER>) {
                if (response != null && response.isSuccessful) {
                    response.body()?.let {

                        callback.onWeatherLoaded(convertToWeatherModel(it))
                    }
                } else {
                    callback.onWeatherNotAvailable()
                }
            }

            override fun onFailure(call: Call<MMWEATHER>, t: Throwable) {
                callback.onWeatherNotAvailable()
            }
        })
    }

    private fun convertToWeatherModel(mmweather: MMWEATHER): List<WeatherModel> {

        val listForecast = mmweather.REPORT?.TOWN?.ListFORECAST
        var listWeather = arrayListOf<WeatherModel>()
        var weatherId = 0

        listForecast?.forEach {
            val tempWeatherModel = WeatherModel(
                weatherId,
                it.day.toString(),
                it.month.toString(),
                it.year.toString(),
                it.hour.toString(),
                it.PHENOMENA?.cloudiness.toString(),
                it.PHENOMENA?.precipitation.toString(),
                it.PRESSURE?.max.toString(),
                it.PRESSURE?.min.toString(),
                it.TEMPERATURE?.max.toString(),
                it.TEMPERATURE?.min.toString(),
                it.WIND?.min.toString(),
                it.WIND?.max.toString(),
                it.WIND?.direction.toString(),
                it.RELWET?.max.toString(),
                it.RELWET?.min.toString(),
                it.HEAT?.min.toString(),
                it.HEAT?.max.toString()
            )
            listWeather.add(tempWeatherModel)
            weatherId++
        }

        return listWeather
    }
}