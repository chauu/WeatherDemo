package com.demo.weather.common.callback

import com.demo.weather.R
import com.kingja.loadsir.callback.Callback

class EmptyCallBack : Callback() {
    override fun onCreateView(): Int = R.layout.layout_empty
}