package com.bohdanzdaniekin.delegate.data.remote.entity

import com.bohdanzdaniekin.delegate.domain.entity.Location
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LocationDto(
    val name: String,
    val url: String
)

fun LocationDto.toLocation(): Location = Location(name, url)