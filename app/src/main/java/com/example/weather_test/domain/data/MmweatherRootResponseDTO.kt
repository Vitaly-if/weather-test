package com.example.weather_test.domain.data

import com.example.weather_test.domain.repository.remote.REPORT
import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "MMWEATHER", strict = false)
class MmWeatherRootResponseDTO {
    @field:Element(name = "REPORT", required = false)
    var report: ReportResponseDTO? = null
}