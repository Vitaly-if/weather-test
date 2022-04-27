package com.example.weather_test.domain.repository

import com.example.weather_test.domain.data.MmWeatherRootResponseDTO
import com.example.weather_test.domain.data.WeatherModel
import com.example.weather_test.domain.repository.remote.MMWEATHER
import com.example.weather_test.domain.repository.remote.WeatherApi
import com.example.weather_test.domain.repository.remote.WeatherApiInterface
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

        apiClient.getWeathers().enqueue(object : Callback<MmWeatherRootResponseDTO> {

            override fun onResponse(call: Call<MmWeatherRootResponseDTO>, response: Response<MmWeatherRootResponseDTO>) {
                if (response != null && response.isSuccessful) {
                    response.body()?.let {

                        callback.onWeatherLoaded(convertToWeatherModel(it))
                    }
                } else {
                    callback.onWeatherNotAvailable()
                }
            }

            override fun onFailure(call: Call<MmWeatherRootResponseDTO>, t: Throwable) {
                callback.onWeatherNotAvailable()
            }
        })
    }

    private fun convertToWeatherModel(mmweather: MmWeatherRootResponseDTO): List<WeatherModel> {

        val listForecast = mmweather.report?.town?.ListForecast
        var listWeather = arrayListOf<WeatherModel>()
        var weatherId = 0

        listForecast?.forEach {
            val tempWeatherModel = WeatherModel(
                weatherId,
                it.day.toString(),
                it.month.toString(),
                it.year.toString(),
                it.hour.toString(),
                it.phenomena?.cloudiness.toString(),
                it.phenomena?.precipitation.toString(),
                it.pressure?.max.toString(),
                it.pressure?.min.toString(),
                it.temperature?.max.toString(),
                it.temperature?.min.toString(),
                it.wind?.min.toString(),
                it.wind?.max.toString(),
                it.wind?.direction.toString(),
                it.relwet?.max.toString(),
                it.relwet?.min.toString(),
                it.heat?.min.toString(),
                it.heat?.max.toString()
            )
            listWeather.add(tempWeatherModel)
            weatherId++
        }

        return listWeather
    }
}