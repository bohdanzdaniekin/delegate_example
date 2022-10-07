package com.bohdanzdaniekin.delegate.data.remote.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PagingInfo(
    val count: Int,
    val pages: Int,
    @Json(name = "next")
    val nextPage: String?,
    @Json(name = "prev")
    val previousPage: String?
)
