package com.demo.weather.module.chooseplace.repository

import androidx.lifecycle.MutableLiveData
import com.demo.weather.base.repository.ApiRepository
import com.demo.weather.common.state.State

class ChoosePlaceRepository(var loadState: MutableLiveData<State>) : ApiRepository() {
}