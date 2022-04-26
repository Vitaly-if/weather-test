package com.example.weather_test.ui

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.weather_test.R
import com.example.weather_test.data.WeatherRepository
import com.example.weather_test.data.models.WeatherModel
import com.example.weather_test.mvp.presenter.WeatherListPresenter
import com.example.weather_test.mvp.view.WeatherListView
import com.example.weather_test.ui.adapters.WeathersAdapter
import com.example.weather_test.ui.utils.showSnackBar
import kotlinx.android.synthetic.main.fragment_weather_list.*
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter


class WeatherListFragment: MvpAppCompatFragment(), WeatherListView {

    @InjectPresenter
    lateinit var presenter: WeatherListPresenter
    private lateinit var weatherAdapter: WeathersAdapter

    @ProvidePresenter
    fun providePresenter(): WeatherListPresenter {
        return WeatherListPresenter(WeatherRepository())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        Log.i(ContentValues.TAG, "Загрузка фрагмента1")
        return inflater.inflate(R.layout.fragment_weather_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onClickUpdate()
        weatherAdapter = WeathersAdapter(ArrayList(0), presenter)
        val linearLayoutManager = LinearLayoutManager(requireContext())
        recycler_weather.apply {
            adapter = weatherAdapter
            layoutManager = linearLayoutManager
        }
    }

    override fun onWeatherLoaded(weathers: List<WeatherModel>) {
        weatherAdapter.weathers = weathers
        textStartView.visibility = View.GONE
        progress_bar.visibility = View.GONE
        recycler_weather.visibility = View.VISIBLE
    }

    override fun openWeatherDetails(selectWeather: WeatherModel) {
        val action = WeatherListFragmentDirections.actionWeatherListFragmentToWeatherDetailFragment(selectWeather)
        findNavController().navigate(action)
    }

    override fun showErrorMsg(msg: Int) {
        view?.showSnackBar(
            getString(msg),
            getString(R.string.snackbar_action_ok),
            View.OnClickListener {  })
        recycler_weather.visibility = View.GONE
        textStartView.visibility = View.VISIBLE
        progress_bar.visibility = View.GONE
    }

    private fun onClickUpdate() {
        buttonUpdate.setOnClickListener {
            textStartView.visibility = View.GONE
            progress_bar.visibility = View.VISIBLE
            presenter.reloadWeathers()
        }

    }

}