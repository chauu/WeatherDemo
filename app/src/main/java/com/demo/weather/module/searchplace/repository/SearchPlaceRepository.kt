package com.demo.weather.module.searchplace.repository

import androidx.lifecycle.MutableLiveData
import com.demo.weather.base.repository.ApiRepository
import com.demo.weather.common.RoomHelper
import com.demo.weather.common.state.State
import com.demo.weather.model.Place
import com.demo.weather.module.searchplace.model.SearchPlaceResponse

class SearchPlaceRepository(var loadState: MutableLiveData<State>) : ApiRepository() {
    suspend fun searchPlaces(query: String) : SearchPlaceResponse {
        return apiService.searchPlaces(query)
    }

    suspend fun insertPlaces(place: Place) = RoomHelper.insertPlace(place)
}