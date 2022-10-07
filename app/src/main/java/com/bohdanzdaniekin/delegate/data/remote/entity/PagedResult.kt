package com.bohdanzdaniekin.delegate.data.remote.entity

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PagedResult<T>(
    val info: PagingInfo,
    val results: T
)

inline fun <T, R> PagedResult<T>.map(transform: (T) -> R): PagedResult<R> =
    PagedResult(info, transform(results))