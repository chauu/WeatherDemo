package com.demo.weather.common.state

import androidx.annotation.StringRes

data class State(var code: StateType, var message: String = "", @StringRes var tip: Int = 0)