package com.demo.weather.module.searchplace.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import com.demo.weather.base.viewmodel.BaseViewModel
import com.demo.weather.module.searchplace.repository.SearchPlaceRepository

class SearchPlaceViewModel(application: Application) : BaseViewModel<SearchPlaceRepository>(application) {
}