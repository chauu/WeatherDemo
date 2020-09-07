package com.demo.weather.common

import androidx.lifecycle.MutableLiveData
import com.demo.weather.base.BaseApplication
import com.demo.weather.common.state.State
import com.demo.weather.common.state.StateType
import com.demo.weather.model.Place
import com.demo.weather.module.chooseplace.model.database.PlaceDataBase

object RoomHelper {
    private val placeDataBase by lazy {
        PlaceDataBase.getInstance(BaseApplication.instance)
    }

    private val placeDao by lazy {
        placeDataBase?.placeDao()
    }

    suspend fun queryAllPlace(loadState: MutableLiveData<State>) : List<Place> {
        val response = placeDao?.queryAllPlace()?.reversed()
        if(response!!.isEmpty()) {
            loadState.postValue(State(StateType.SUCCESS))
        }
        return response
    }

    suspend fun insertPlace(place: Place) {
        placeDao?.let {
            it.queryPlaceByName(place.name)?.let {
                var i = placeDao!!.deleteArticle(place)
            }
            it.insertPlace(place.apply { primaryKey = 0 })
        }
    }

    suspend fun deletePlace(place: Place) {
        placeDao?.deleteArticle(place)
    }

    suspend fun deleteAll() {
        placeDao?.deleteAll()
    }
}