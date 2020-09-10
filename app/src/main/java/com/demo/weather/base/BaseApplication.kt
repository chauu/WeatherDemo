package com.demo.weather.base

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import com.demo.weather.common.callback.EmptyCallBack
import com.demo.weather.common.callback.ErrorCallBack
import com.demo.weather.common.callback.LoadingCallBack
import com.kingja.loadsir.core.LoadSir

open class BaseApplication : Application(), ViewModelStoreOwner {
    lateinit var mApplicationModelStore: ViewModelStore

    private var mFactory: ViewModelProvider.Factory? = null

    companion object {
        lateinit var instance : BaseApplication
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        initLoadSir()
        mApplicationModelStore = ViewModelStore()
    }

    private fun initLoadSir(){
        LoadSir.beginBuilder()
            .addCallback(EmptyCallBack())
            .addCallback(ErrorCallBack())
            .addCallback(LoadingCallBack())
            .commit()
    }

    override fun getViewModelStore(): ViewModelStore {
        return mApplicationModelStore
    }

    fun getAppViewModelProvider(): ViewModelProvider {
        return ViewModelProvider(this, this.getAppFactory())
    }

    private fun getAppFactory(): ViewModelProvider.Factory {
        if(mFactory == null) {
            mFactory = ViewModelProvider.AndroidViewModelFactory.getInstance((this))
        }

        return mFactory as ViewModelProvider.Factory
    }
}