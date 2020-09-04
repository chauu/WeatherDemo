package com.demo.weather.module.main

import com.demo.weather.R
import com.demo.weather.base.view.BaseLifeCycleActivity
import com.demo.weather.databinding.ActivityMainBinding

class MainActivity : BaseLifeCycleActivity<MainViewModel, ActivityMainBinding>(){
    override fun getLayoutId(): Int = R.layout.activity_main
}