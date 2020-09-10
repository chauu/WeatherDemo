package com.demo.weather.module.addedplace.repository

import androidx.lifecycle.MutableLiveData
import com.demo.weather.base.repository.ApiRepository
import com.demo.weather.common.RoomHelper
import com.demo.weather.common.state.State
import com.demo.weather.model.Place

class ChoosePlaceRepository(var loadState: MutableLiveData<State>) : ApiRepository() {
    suspend fun queryAllPlace() = RoomHelper.queryAllPlace(loadState)
    suspend fun deletePlace(place: Place) = RoomHelper.deletePlace(place)
    suspend fun deleteAll() = RoomHelper.deleteAll()
}