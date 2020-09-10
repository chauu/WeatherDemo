package com.demo.weather.module.home.repository

import androidx.lifecycle.MutableLiveData
import com.demo.weather.base.repository.ApiRepository
import com.demo.weather.common.RoomHelper
import com.demo.weather.common.state.State

class HomeRepository (var loadState: MutableLiveData<State>) : ApiRepository(){
    suspend fun queryFirstPlace() = RoomHelper.queryFirstPlace(loadState)

    suspend fun loadRealTimeWeather(lng: String?, lat: String?) = apiService.loadRealtimeWeather(lng, lat)

    suspend fun loadDailyWeather(lng: String?, lat: String?) = apiService.loadDailyWeather(lng, lat)

    suspend fun loadHourlyWeather(lng: String?, lat: String?) = apiService.loadHourlyWeather(lng, lat)
}