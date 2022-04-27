package com.example.weather_test.domain.data

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Root

@Root(name = "WIND", strict = false)
class WindResponseDTO {
    @field:Attribute(name = "min", required = false)
    var min = 0
    @field:Attribute(name = "max", required = false)
    var max = 0
    @field:Attribute(name = "direction", required = false)
    var direction = 0
}