package com.demo.weather.network

import com.demo.weather.common.Constant
import com.demo.weather.module.searchplace.model.SearchPlaceResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("v2/place?token=${Constant.CAIYUN_TOKEN}&lang=zh_CN")
    suspend fun searchPlaces(@Query("query") query : String) : SearchPlaceResponse
}