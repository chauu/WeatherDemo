package com.demo.weather.base

import android.app.Application
import com.demo.weather.common.callback.EmptyCallBack
import com.demo.weather.common.callback.ErrorCallBack
import com.demo.weather.common.callback.LoadingCallBack
import com.kingja.loadsir.core.LoadSir

open class BaseApplication : Application() {
    companion object {
        lateinit var instance : BaseApplication
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        initLoadSir()
    }

    private fun initLoadSir(){
        LoadSir.beginBuilder()
            .addCallback(EmptyCallBack())
            .addCallback(ErrorCallBack())
            .addCallback(LoadingCallBack())
            .commit()
    }
}