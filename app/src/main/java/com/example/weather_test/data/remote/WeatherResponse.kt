package com.example.weather_test.data.remote

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "PRESSURE", strict = false)
    class PRESSURE {
    @field:Attribute(name = "min", required = false)
    var min = 0
    @field:Attribute(name = "max", required = false)
    var max = 0
    }
    @Root(name = "TEMPERATURE", strict = false)
    class TEMPERATURE {
        @field:Attribute(name = "min", required = false)
        var min = 0
        @field:Attribute(name = "max", required = false)
        var max = 0
    }
    @Root(name = "WIND", strict = false)
    class WIND {
        @field:Attribute(name = "min", required = false)
        var min = 0
        @field:Attribute(name = "max", required = false)
        var max = 0
        @field:Attribute(name = "direction", required = false)
        var direction = 0
    }
    @Root(name = "RELWET", strict = false)
    class RELWET {
        @field:Attribute(name = "min", required = false)
        var min = 0
        @field:Attribute(name = "max", required = false)
        var max = 0
    }
    @Root(name = "HEAT", strict = false)
    class HEAT {
        @field:Attribute(name = "min", required = false)
        var min = 0
        @field:Attribute(name = "max", required = false)
        var max = 0
    }

    @Root(name = "TOWN", strict = false)
    class TOWN {
        @field:ElementList(inline = true)
        var ListFORECAST: List<Forecast>? = null
        @field:Attribute(name = "index", required = false)
        var index = 0
        @field:Attribute(name = "sname", required = false)
        var sname: String? = null
        @field:Attribute(name = "latitude", required = false)
        var latitude = 0
        @field:Attribute(name = "longitude", required = false)
        var longitude = 0
    }
    @Root(name = "REPORT", strict = false)
    class REPORT {
        @field:Element(name = "TOWN", required = false)
        var TOWN: TOWN? = null
        @field:Attribute(name = "type", required = false)
        var type: String? = null
    }
    @Root(name = "MMWEATHER", strict = false)
    class MMWEATHER {
        @field:Element(name = "REPORT", required = false)
        var REPORT: REPORT? = null
    }
@Root(strict = false, name = "FORECAST")
class Forecast {
    @field:Element(name = "PHENOMENA", required = false)
    var PHENOMENA: PHENOMENA? = null
    @field:Element(name = "PRESSURE", required = false)
    var PRESSURE: PRESSURE? = null
    @field:Element(name = "TEMPERATURE", required = false)
    var TEMPERATURE: TEMPERATURE? = null
    @field:Element(name = "WIND", required = false)
    var WIND: WIND? = null
    @field:Element(name = "RELWET", required = false)
    var RELWET: RELWET? = null
    @field:Element(name = "HEAT", required = false)
    var HEAT: HEAT? = null
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
@Root(name = "PHENOMENA", strict = false)
class PHENOMENA {
    @field:Attribute(name = "cloudiness", required = false)
    var cloudiness = 0
    @field:Attribute(name = "precipitation", required = false)
    var precipitation = 0
    @field:Attribute(name = "rpower", required = false)
    var rpower = 0
    @field:Attribute(name = "spower", required = false)
    var spower = 0
}


