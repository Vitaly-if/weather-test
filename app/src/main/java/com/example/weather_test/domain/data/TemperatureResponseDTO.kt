package com.example.weather_test.domain.data

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Root

@Root(name = "TEMPERATURE", strict = false)
class TemperatureResponseDTO {
        @field:Attribute(name = "min", required = false)
        var min = 0
        @field:Attribute(name = "max", required = false)
        var max = 0
    }