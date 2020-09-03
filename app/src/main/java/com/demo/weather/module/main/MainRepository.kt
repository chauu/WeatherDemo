package com.demo.weather.module.main

import androidx.lifecycle.MutableLiveData
import com.demo.weather.base.repository.ApiRepository
import com.demo.weather.common.state.State

class MainRepository(var loadState: MutableLiveData<State>) : ApiRepository() {
}