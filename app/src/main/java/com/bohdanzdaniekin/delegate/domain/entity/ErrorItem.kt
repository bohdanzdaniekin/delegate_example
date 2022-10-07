package com.bohdanzdaniekin.delegate.domain.entity

data class ErrorItem(
    val message: String = "UnexpectedError",
    val cause: Throwable
) : ListItem {

    override val itemId: Long = 1
}
