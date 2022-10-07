package com.bohdanzdaniekin.delegate.domain.entity

import com.bohdanzdaniekin.delegate.ui.util.extensions.firstOrDefault

enum class Gender(val value: String) {
    MALE("Male"),
    FEMALE("Female"),
    GENDERLESS("Genderless"),
    UNKNOWN("unknown");

    fun isMale(): Boolean = this == MALE

    fun isFemale(): Boolean = this == FEMALE

    companion object {

        fun from(value: String): Gender =
            values().firstOrDefault(UNKNOWN) { gender ->
                gender.value.contentEquals(value, ignoreCase = true)
            }
    }
}