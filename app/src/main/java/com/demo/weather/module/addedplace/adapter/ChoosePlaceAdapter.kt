package com.demo.weather.module.addedplace.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.demo.weather.R
import com.demo.weather.common.setAdapterAnimation
import com.demo.weather.model.Place

class ChoosePlaceAdapter(layout: Int, listData: MutableList<Place>?) :
    BaseQuickAdapter<Place, BaseViewHolder>(layout, listData){

    init {
        setAdapterAnimation(4)
    }

    override fun convert(holder: BaseViewHolder, item: Place) {
        holder.let {
            holder -> item.let {
                holder.setText(R.id.location_name, item.name)
            }
        }
    }
}