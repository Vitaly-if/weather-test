package com.example.weather_test.data.remote

import retrofit2.Call
import retrofit2.http.GET

interface WeatherApiInterface {
    @GET("29634_1.xml")
    fun getWeathers(): Call<MMWEATHER>
}