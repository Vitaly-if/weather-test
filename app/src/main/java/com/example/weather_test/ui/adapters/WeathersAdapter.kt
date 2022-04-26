package com.example.weather_test.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weather_test.R
import com.example.weather_test.data.models.WeatherModel
import com.example.weather_test.mvp.presenter.WeatherListPresenter

class WeathersAdapter(weathers: List<WeatherModel>, val presenter: WeatherListPresenter) :
    RecyclerView.Adapter<WeathersAdapter.ViewHolder>() {

    var weathers: List<WeatherModel> = weathers
        set(wearhers) {
            field = wearhers
            notifyDataSetChanged()
        }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textDateWeek: TextView
        val textDate: TextView
        val textTempMax: TextView
        val textTempMin: TextView
        val cloudinessImg: ImageView

        init {
            textDateWeek = itemView.findViewById(R.id.text_date_of_week)
            textDate = itemView.findViewById(R.id.text_date)
            textTempMax = itemView.findViewById(R.id.text_temperature_max)
            textTempMin = itemView.findViewById(R.id.text_temperature_min)
            cloudinessImg = itemView.findViewById(R.id.cloudinessImg)
        }

        fun bindView(position: Int) {

            textDateWeek.text = getPeriodDay(weathers[position].forecastHour)
            textDate.text = "${weathers[position].forecastDay} ${getMonthText(weathers[position].forecastMonth)}"
            textTempMax.text = "${weathers[position].temperatureMax}°"
            textTempMin.text = "${weathers[position].temperatureMin}°"
            cloudinessImg.setImageResource(getCloudImg(weathers[position].phenomenaCloud))
            itemView.setOnClickListener {
                presenter.showDetails(weathers[position])
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View
        view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_weather, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(position)

    }

    override fun getItemCount() = weathers.size


}
