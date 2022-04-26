package com.example.weather_test.data.remote

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.Root
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

private const val BASE_URL = "http://informer.gismeteo.ru/xml/"

object WeatherApi {

    private lateinit var retrofit: Retrofit

    val client: Retrofit
        get() {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build()
            return retrofit
        }



//    fun trendingApi(){
//       val retrofit = Retrofit.Builder()
//            .addConverterFactory(SimpleXmlConverterFactory.create())
//            .baseUrl(BASE_URL)
//            .build()
//        val trendingApi = retrofit.create(WeatherApiInterface::class.java)
//
//        GlobalScope.launch(Dispatchers.IO) {
//            delay(2000)
//            println("Kotlin Coroutines World22!")
//            val list = trendingApi.getProperties().REPORT?.TOWN?.ListFORECAST
//            list?.forEach {
//                println("Запуск TEMPERATURE min ${it.TEMPERATURE?.min} " +
//                        "TEMPERATURE max ${it.TEMPERATURE?.max}")
//            }
//
//            //   Log.i(ContentValues.TAG, " ${weather.name}")
//        }
//
//
//
//    }

    //val retrofitService : WeatherApiInterface by lazy {
  //  val trendingApi = retrofit.create(WeatherApiInterface::class.java)
    //}
}

@Root(name = "REPORT", strict = false)
data class Feed(
    @field:Element(name = "REPORT")
    var report: String? = null,
    @field:Attribute(name="type", required = false)
    var type: String? = null,
    @field:Element(name = "TOWN")
    var town: String? = null,
    @field:Attribute(name="index", required = false)
    var index: String? = "хрен там плавал",
    @field:Attribute(name="sname", required = false)
    var sname: String? = null,
    @field:Attribute(name="latitude", required = false)
    var latitude: String? = null,
    @field:Attribute(name="longitude", required = false)
    var longitude: String? = null
)



