package com.demo.weather.module.searchplace.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.demo.weather.base.viewmodel.BaseViewModel
import com.demo.weather.common.initiateRequest
import com.demo.weather.module.searchplace.model.SearchPlaceResponse
import com.demo.weather.module.searchplace.repository.SearchPlaceRepository

class SearchPlaceViewModel(application: Application) : BaseViewModel<SearchPlaceRepository>(application) {
    val mSearchPlacesDate: MutableLiveData<SearchPlaceResponse> = MutableLiveData()

    fun searchPlaces(query: String){
        initiateRequest({
            mSearchPlacesDate.value = mRepository.searchPlaces(query)
        }, loadState)
    }
}