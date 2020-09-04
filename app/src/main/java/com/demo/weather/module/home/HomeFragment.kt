package com.demo.weather.module.home

import androidx.appcompat.app.AppCompatActivity
import com.demo.weather.R
import com.demo.weather.base.view.BaseLifeCycleFragment
import com.demo.weather.databinding.HomeFragmentBinding
import kotlinx.android.synthetic.main.layout_home_toolbar.*

class HomeFragment : BaseLifeCycleFragment<HomeViewModel, HomeFragmentBinding>() {
    override fun initView() {
        super.initView()
        (requireActivity() as AppCompatActivity).setSupportActionBar(home_toolbar)
    }

    override fun getLayoutId(): Int = R.layout.home_fragment
}