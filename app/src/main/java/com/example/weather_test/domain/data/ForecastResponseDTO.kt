package com.example.weather_test.domain.data

import com.example.weather_test.domain.repository.remote.*
import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(strict = false, name = "FORECAST")
class ForecastResponseDTO {
    @field:Element(name = "PHENOMENA", required = false)
    var phenomena: PhenomenaResponseDTO? = null
    @field:Element(name = "PRESSURE", required = false)
    var pressure: PressureResponseDTO? = null
    @field:Element(name = "TEMPERATURE", required = false)
    var temperature: TemperatureResponseDTO? = null
    @field:Element(name = "WIND", required = false)
    var wind: WindResponseDTO? = null
    @field:Element(name = "RELWET", required = false)
    var relwet: RelwetResponseDTO? = null
    @field:Element(name = "HEAT", required = false)
    var heat: HeatResponseDTO? = null
    @field:Attribute(name = "day", required = false)
    var day = 0
    @field:Attribute(name = "month", required = false)
    var month = 0
    @field:Attribute(name = "year", required = false)
    var year = 0
    @field:Attribute(name = "hour", required = false)
    var hour = 0
    @field:Attribute(name = "tod", required = false)
    var tod = 0
    @field:Attribute(name = "predict", required = false)
    var predict = 0
    @field:Attribute(name = "weekday", required = false)
    var weekday = 0
}