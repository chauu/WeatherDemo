package com.demo.weather.network

import com.demo.weather.common.Constant
import com.demo.weather.model.DailyResponse
import com.demo.weather.model.HourlyResponse
import com.demo.weather.model.RealTimeResponse
import com.demo.weather.module.searchplace.model.SearchPlaceResponse
import okhttp3.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("v2/place?token=${Constant.CAIYUN_TOKEN}&lang=zh_CN")
    suspend fun searchPlaces(@Query("query") query: String): SearchPlaceResponse

    @GET("v2.5/${Constant.CAIYUN_TOKEN}/{lng},{lat}/realtime.json")
    suspend fun loadRealtimeWeather(
        @Path("lng") lng: String?,
        @Path("lat") lat: String?
    ): RealTimeResponse

    @GET("v2.5/${Constant.CAIYUN_TOKEN}/{lng},{lat}/daily.json")
    suspend fun loadDailyWeather(@Path("lng") lng: String?, @Path("lat") lat: String?): DailyResponse

    @GET("v2.5/${Constant.CAIYUN_TOKEN}/{lng},{lat}/hourly.json")
    suspend fun loadHourlyWeather(
        @Path("lng") lng: String?,
        @Path("lat") lat: String?
    ): HourlyResponse
}