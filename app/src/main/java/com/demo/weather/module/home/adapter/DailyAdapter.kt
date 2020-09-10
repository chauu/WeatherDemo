package com.demo.weather.module.home.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.demo.weather.R
import com.demo.weather.common.DateUtil
import com.demo.weather.common.getSky
import com.demo.weather.model.DailyResponse

class DailyAdapter (layout: Int, data: MutableList<DailyResponse.DailyData>?):
    BaseQuickAdapter<DailyResponse.DailyData, BaseViewHolder>(layout, data){

    override fun convert(holder: BaseViewHolder, item: DailyResponse.DailyData) {
        holder.let { holder ->
            item.let {
                holder.setText(R.id.date, DateUtil.getTodayInWeek(item.date))
                    .setImageResource(R.id.weather, getSky(item.value).icon)
                    .setText(R.id.temperature, "${item.min.toInt()}℃~ ${item.max.toInt()}℃")
            }
        }
    }

}