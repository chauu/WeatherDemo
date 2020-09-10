package com.demo.weather.module.main

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.demo.weather.base.viewmodel.BaseViewModel
import com.demo.weather.model.Place

class AppViewModel(application: Application) : BaseViewModel<MainRepository>(application) {
    var currentPlace = MutableLiveData<Place>()

    fun  changeCurrentPlace(place: Place) {
        currentPlace.value = place
    }
}