package com.demo.weather.module.searchplace.model

import com.demo.weather.model.Place

data class SearchPlaceResponse(
    val status: String,
    val places: MutableList<Place>
)