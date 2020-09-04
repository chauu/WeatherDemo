package com.demo.weather.module.searchplace.repository

import androidx.lifecycle.MutableLiveData
import com.demo.weather.base.repository.ApiRepository
import com.demo.weather.common.state.State

class SearchPlaceRepository(var loadState: MutableLiveData<State>) : ApiRepository() {
}