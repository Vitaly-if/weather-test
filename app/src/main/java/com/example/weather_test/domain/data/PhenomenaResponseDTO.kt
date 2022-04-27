package com.example.weather_test.domain.data

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Root

@Root(name = "PHENOMENA", strict = false)
class PhenomenaResponseDTO {
    @field:Attribute(name = "cloudiness", required = false)
    var cloudiness = 0
    @field:Attribute(name = "precipitation", required = false)
    var precipitation = 0
    @field:Attribute(name = "rpower", required = false)
    var rpower = 0
    @field:Attribute(name = "spower", required = false)
    var spower = 0
}
