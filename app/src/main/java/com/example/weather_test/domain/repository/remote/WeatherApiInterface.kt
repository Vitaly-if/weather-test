package com.example.weather_test.domain.repository.remote

import com.example.weather_test.domain.data.MmWeatherRootResponseDTO
import retrofit2.Call
import retrofit2.http.GET

interface WeatherApiInterface {
    @GET("29634_1.xml")
    fun getWeathers(): Call<MmWeatherRootResponseDTO>
}