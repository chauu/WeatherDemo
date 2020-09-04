package com.demo.weather.common

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.demo.weather.base.repository.BaseRepository
import com.demo.weather.base.viewmodel.BaseViewModel
import com.demo.weather.common.state.State
import com.demo.weather.network.NetExceptionHandle
import kotlinx.coroutines.launch

fun <T : BaseRepository> BaseViewModel<T>.initiateRequest(
    block: suspend ()-> Unit,
    loadState: MutableLiveData<State>
) {
    viewModelScope.launch {
        kotlin.runCatching {
            block()
            Log.d("Ext","success")
        }.onSuccess {
            Log.d("Ext","onSuccess")
        }.onFailure {
            Log.d("Ext","onFailure")
            NetExceptionHandle.handleException(it, loadState)
        }
    }
}