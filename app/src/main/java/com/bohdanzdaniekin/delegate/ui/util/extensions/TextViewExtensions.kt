package com.bohdanzdaniekin.delegate.ui.util.extensions

import android.text.InputFilter
import android.widget.TextView

fun TextView.isEmpty() = text.isEmpty()

fun TextView.setMaxLength(maxLength: Int) {
    val maxLengthFilter = InputFilter.LengthFilter(maxLength)

    filters.forEachIndexed { i, inputFilter ->
        if (inputFilter is InputFilter.LengthFilter) {
            filters[i] = maxLengthFilter
            return
        }
    }

    filters = filters.toMutableList().apply { add(maxLengthFilter) }.toTypedArray()
}