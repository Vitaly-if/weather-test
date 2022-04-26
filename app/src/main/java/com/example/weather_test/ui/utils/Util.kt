package com.example.weather_test.ui.adapters

import com.example.weather_test.R

fun getPeriodDay(weekDay: String): String {

    return when (weekDay) {
        "4" -> "Ночь"
        "10" -> "Утро"
        "16" -> "День"
        "22" -> "Вечер"
        else -> ""
    }
}

fun getCloudImg(cloud: String): Int {

    return when (cloud) {
        "-1" -> R.drawable.fog
        "0" -> R.drawable.day_clear
        "1" -> R.drawable.day_partial_cloud
        "2" -> R.drawable.cloudy
        "3" -> R.drawable.overcast
        else -> R.drawable.day_clear
    }
}

fun getCloudText(cloud: String): String {

    return when (cloud) {
        "-1" -> "Туман"
        "0" -> "Ясно"
        "1" -> "Малооблачно"
        "2" -> "Облачно"
        "3" -> "Пасмурно"
        else -> ""
    }
}

fun getMonthText(month: String): String {

    return when (month) {
        "1" -> "Января"
        "2" -> "Февраля"
        "3" -> "Марта"
        "4" -> "Апреля"
        "5" -> "Мая"
        "6" -> "Июня"
        "7" -> "Июля"
        "8" -> "Августа"
        "9" -> "Сентября"
        "10" -> "Октября"
        "11" -> "Ноября"
        "12" -> "Декабря"
        else -> ""
    }
}

fun getWindDirectionText(direction: String): String {

    return when (direction) {
        "1" -> "северный"
        "2" -> "северо-восточный"
        "3" -> "восточный"
        "4" -> "юго-восточный"
        "5" -> "южный"
        "6" -> "юго-западный"
        "7" -> "западный"
        "8" -> "северо-западный"
        else -> ""
    }
}


