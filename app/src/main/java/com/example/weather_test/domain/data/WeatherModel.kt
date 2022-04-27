package com.example.weather_test.domain.data

import android.os.Parcel
import android.os.Parcelable

class WeatherModel : Parcelable {

    var forecastID: Int = 0

    var forecastDay: String = ""

    var forecastMonth: String = ""

    var forecastYear: String = ""

    var forecastHour: String = ""

    var phenomenaCloud: String = ""

    var phenomenaPrecip: String = ""

    var pressureMax: String = ""

    var pressureMin: String = ""

    var temperatureMax: String = ""

    var temperatureMin: String = ""

    var windMin: String = ""

    var windMax: String = ""

    var windDirection: String = ""

    var relwetMax: String = ""

    var relwetMin: String = ""

    var heatMin: String = ""

    var heatMax: String = ""

    constructor(parcel: Parcel) {
        forecastID = parcel.readInt()
        forecastDay = parcel.readString().toString()
        forecastMonth = parcel.readString().toString()
        forecastYear = parcel.readString().toString()
        forecastHour = parcel.readString().toString()
        phenomenaCloud = parcel.readString().toString()
        phenomenaPrecip = parcel.readString().toString()
        pressureMax = parcel.readString().toString()
        pressureMin = parcel.readString().toString()
        temperatureMax = parcel.readString().toString()
        temperatureMin = parcel.readString().toString()
        windMin = parcel.readString().toString()
        windMax = parcel.readString().toString()
        windDirection = parcel.readString().toString()
        relwetMax = parcel.readString().toString()
        relwetMin = parcel.readString().toString()
        heatMin = parcel.readString().toString()
        heatMax = parcel.readString().toString()
    }

    constructor(
        forecastID: Int, forecastDay: String, forecastMonth: String, forecastYear: String,
        forecastHour: String, phenomenaCloud: String, phenomenaPrecip: String,
        pressureMax: String, pressureMin: String, temperatureMax: String,
        temperatureMin: String, windMin: String, windMax: String, windDirection: String,
        relwetMax: String, relwetMin: String, heatMin: String, heatMax: String
    ) {
        this.forecastID = forecastID
        this.forecastDay = forecastDay
        this.forecastMonth = forecastMonth
        this.forecastYear = forecastYear
        this.forecastHour = forecastHour
        this.phenomenaCloud = phenomenaCloud
        this.phenomenaPrecip = phenomenaPrecip
        this.pressureMax = pressureMax
        this.pressureMin = pressureMin
        this.temperatureMax = when (temperatureMax.toInt()) {
            in 1..100 -> "+$temperatureMax"
            else -> temperatureMax
        }
        this.temperatureMin = when (temperatureMin.toInt()) {
            in 1..100 -> "+$temperatureMin"
            else -> temperatureMin
        }
        this.windMin = windMin
        this.windMax = windMax
        this.windDirection = windDirection
        this.relwetMax = relwetMax
        this.relwetMin = relwetMin
        this.heatMin = heatMin
        this.heatMax = heatMax
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(forecastID)
        parcel.writeString(forecastDay)
        parcel.writeString(forecastMonth)
        parcel.writeString(forecastYear)
        parcel.writeString(phenomenaCloud)
        parcel.writeString(phenomenaPrecip)
        parcel.writeString(pressureMax)
        parcel.writeString(pressureMin)
        parcel.writeString(temperatureMax)
        parcel.writeString(temperatureMin)
        parcel.writeString(windMin)
        parcel.writeString(windMax)
        parcel.writeString(windDirection)
        parcel.writeString(relwetMax)
        parcel.writeString(relwetMin)
        parcel.writeString(heatMin)
        parcel.writeString(heatMax)
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as WeatherModel

        if (forecastID != other.forecastID) return false

        return true
    }

    override fun hashCode(): Int {
        return forecastID.hashCode()
    }

    companion object CREATOR : Parcelable.Creator<WeatherModel> {
        override fun createFromParcel(parcel: Parcel): WeatherModel {
            return WeatherModel(parcel)
        }

        override fun newArray(size: Int): Array<WeatherModel?> {
            return arrayOfNulls(size)
        }
    }

}