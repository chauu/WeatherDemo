package com.demo.weather.common.callback

import com.demo.weather.R
import com.kingja.loadsir.callback.Callback

class ErrorCallBack : Callback() {
    override fun onCreateView(): Int = R.layout.layout_error
}