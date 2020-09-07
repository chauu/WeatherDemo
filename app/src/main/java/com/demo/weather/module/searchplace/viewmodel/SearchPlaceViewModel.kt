package com.demo.weather.module.searchplace.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.weather.base.viewmodel.BaseViewModel
import com.demo.weather.common.initiateRequest
import com.demo.weather.model.Place
import com.demo.weather.module.searchplace.model.SearchPlaceResponse
import com.demo.weather.module.searchplace.repository.SearchPlaceRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SearchPlaceViewModel(application: Application) : BaseViewModel<SearchPlaceRepository>(application) {
    val mSearchPlacesDate: MutableLiveData<SearchPlaceResponse> = MutableLiveData()

    fun searchPlaces(query: String){
        initiateRequest({
            mSearchPlacesDate.value = mRepository.searchPlaces(query)
        }, loadState)
    }

    fun insertPlace(place: Place) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                mRepository.insertPlaces(place)
            }
        }
    }
}