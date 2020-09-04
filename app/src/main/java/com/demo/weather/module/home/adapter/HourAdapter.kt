package com.demo.weather.module.home.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.demo.weather.R

class HourAdapter (layout: Int, data: MutableList<String>?) : BaseQuickAdapter<String, BaseViewHolder>(layout, data){
    override fun convert(helper: BaseViewHolder?, item: String?) {
        helper?.let { holder ->
            item?.let {
                holder.setText(R.id.time, item)
                holder.setText(R.id.temperature, "20")
            }
        }
    }

}