package com.example.weather_test.domain.data

import com.example.weather_test.domain.repository.remote.TOWN
import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "REPORT", strict = false)
class ReportResponseDTO {
    @field:Element(name = "TOWN", required = false)
    var town: ThownResponseDTO? = null
    @field:Attribute(name = "type", required = false)
    var type: String? = null
}