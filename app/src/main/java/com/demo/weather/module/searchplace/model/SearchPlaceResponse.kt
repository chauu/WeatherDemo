package com.demo.weather.module.searchplace.model

import com.demo.weather.module.chooseplace.model.Place

data class SearchPlaceResponse(
    val status: String,
    val places: List<Place>
)