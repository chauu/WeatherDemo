package com.demo.weather.module.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.demo.weather.R
import com.demo.weather.base.view.BaseLifeCycleActivity

class MainActivity : BaseLifeCycleActivity<MainViewModel>(){
    override fun getLayoutId(): Int = R.layout.activity_main

    override fun initView() {
        super.initView()
    }
}