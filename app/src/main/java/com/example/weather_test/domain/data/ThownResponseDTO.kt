package com.example.weather_test.domain.data

import com.example.weather_test.domain.repository.remote.Forecast
import org.simpleframework.xml.Attribute
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "TOWN", strict = false)
class ThownResponseDTO {
    @field:ElementList(inline = true)
    var ListForecast: List<ForecastResponseDTO>? = null
    @field:Attribute(name = "index", required = false)
    var index = 0
    @field:Attribute(name = "sname", required = false)
    var sname: String? = null
    @field:Attribute(name = "latitude", required = false)
    var latitude = 0
    @field:Attribute(name = "longitude", required = false)
    var longitude = 0
}