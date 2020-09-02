package com.demo.weather.base.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.demo.weather.base.repository.BaseRepository
import com.demo.weather.common.Utils
import com.demo.weather.common.state.State

open class BaseViewModel<T : BaseRepository>(application: Application) : AndroidViewModel(application) {
    val loadState by lazy {
        MutableLiveData<State>()
    }

    val mRepository : T by lazy {
        (Utils.getClass<T>(this))
            .getDeclaredConstructor(MutableLiveData::class.java)
            .newInstance(loadState)
    }

    override fun onCleared() {
        super.onCleared()
        mRepository.unSubscribe()
    }
}