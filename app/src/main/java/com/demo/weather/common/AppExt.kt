package com.demo.weather.common

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.demo.weather.base.BaseApplication
import com.demo.weather.module.main.AppViewModel

fun AppCompatActivity.getAppViewModel(): AppViewModel {
    BaseApplication.instance.let {
        return it.getAppViewModelProvider().get(AppViewModel::class.java)
    }
}

fun Fragment.getAppViewModel(): AppViewModel {
    BaseApplication.instance.let {
        return it.getAppViewModelProvider().get(AppViewModel::class.java)
    }
}