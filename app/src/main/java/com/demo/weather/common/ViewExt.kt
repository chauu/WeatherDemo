package com.demo.weather.common

import com.chad.library.adapter.base.BaseQuickAdapter

fun BaseQuickAdapter<*, *>.setAdapterAnimation(model: Int){
    if(model == 0){
        this.animationEnable = false
    } else {
        this.animationEnable = true
        this.setAnimationWithDefault(BaseQuickAdapter.AnimationType.values()[2])
    }
}