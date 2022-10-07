package com.bohdanzdaniekin.delegate.domain.entity

import com.bohdanzdaniekin.delegate.ui.util.extensions.firstOrDefault

enum class Status(val value: String) {
    ALIVE("Alive"),
    DEAD("Dead"),
    UNKNOWN("unknown");

    fun isDead(): Boolean = this == DEAD

    companion object {

        fun from(value: String): Status =
            values().firstOrDefault(UNKNOWN) { status ->
                status.value.contentEquals(value, ignoreCase = true)
            }
    }
}