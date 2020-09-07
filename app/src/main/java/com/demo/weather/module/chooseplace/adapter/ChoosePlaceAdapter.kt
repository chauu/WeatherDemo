package com.demo.weather.module.chooseplace.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.demo.weather.R
import com.demo.weather.model.Place

class ChoosePlaceAdapter(layout: Int, listData: MutableList<Place>?) :
    BaseQuickAdapter<Place, BaseViewHolder>(layout, listData){
    override fun convert(helper: BaseViewHolder?, item: Place?) {
        helper?.let {
            holder -> item?.let {
                holder.setText(R.id.location_name, item.name)
            }
        }
    }
}