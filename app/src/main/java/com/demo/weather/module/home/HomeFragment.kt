package com.demo.weather.module.home

import com.demo.weather.R
import com.demo.weather.base.view.BaseLifeCycleFragment

class HomeFragment : BaseLifeCycleFragment<HomeViewModel>() {
    override fun initDataObserver() {
    }

    override fun getLayoutId(): Int = R.layout.home_fragment
}