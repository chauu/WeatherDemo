package com.demo.weather.base.repository

import com.demo.weather.network.ApiService
import com.demo.weather.network.RetrofitFactory

abstract class ApiRepository : BaseRepository(){
    protected val apiService: ApiService by lazy {
        RetrofitFactory.instance.createRetrofit(ApiService::class.java)
    }
}