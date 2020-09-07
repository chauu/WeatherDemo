package com.demo.weather.module.searchplace.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.demo.weather.R
import com.demo.weather.model.Place

class SearchPlaceAdapter(layout: Int, data: MutableList<Place>?) : BaseQuickAdapter<Place, BaseViewHolder>(layout, data) {
    override fun convert(helper: BaseViewHolder?, item: Place?) {
        helper?.let { holder ->
            item?.let {
                holder.setText(R.id.placeName, item.name)
                holder.setText(R.id.placeAddress, item.address)
            }
        }
    }
}