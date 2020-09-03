package com.demo.weather.module.place.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.demo.weather.R

class ChoosePlaceAdapter(layout: Int, listData: MutableList<String>) :
    BaseQuickAdapter<String, BaseViewHolder>(layout, listData){
    override fun convert(helper: BaseViewHolder?, item: String?) {
        helper?.let {
            holder -> item?.let {
                holder.setText(R.id.location_name, item)
            }
        }
    }
}