package com.example.weather_test.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.weather_test.R
import com.example.weather_test.data.models.WeatherModel
import com.example.weather_test.mvp.presenter.WeatherDetailPresenter
import com.example.weather_test.mvp.view.WeatherDetailView
import com.example.weather_test.ui.adapters.*
import kotlinx.android.synthetic.main.fragment_weather_detail.*
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter


class WeatherDetailFragment : MvpAppCompatFragment(), WeatherDetailView {

    @InjectPresenter
    lateinit var presenter: WeatherDetailPresenter

    @ProvidePresenter
    fun providePresenter(): WeatherDetailPresenter {
        val args: WeatherDetailFragmentArgs by navArgs()
        return WeatherDetailPresenter(args.weatherSelect)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_weather_detail, container, false)
    }

    override fun onWeatherLoaded(weather: WeatherModel) {
        textPeriodDay.text = getPeriodDay(weather.forecastHour)
        textMonth.text =
            getString(R.string.text_month, weather.forecastDay, getMonthText(weather.forecastMonth))
        cloud_imageView.setImageResource(getCloudImg(weather.phenomenaCloud))
        textCloud.text = getCloudText(weather.phenomenaCloud)
        textTempMax.text = getString(R.string.text_temperature, weather.temperatureMax)
        textTempMin.text = getString(R.string.text_temperature, weather.temperatureMin)
        textPressure.text =
            getString(R.string.text_pressure, weather.pressureMin, weather.pressureMax)
        textRelvet.text = getString(R.string.text_relvet, weather.relwetMin, weather.relwetMax)
        textWind.text = getString(
            R.string.text_wind,
            getWindDirectionText(weather.windDirection),
            weather.windMin,
            weather.windMax
        )

    }

}
