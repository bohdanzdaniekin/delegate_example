package com.bohdanzdaniekin.delegate.ui.util.extensions

import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.google.android.material.textfield.TextInputEditText

fun TextInputEditText.isNotBlank() = text!!.isNotBlank()

fun TextInputEditText.isBlank() = text!!.isBlank()

inline val View.layoutInflater get() = context.layoutInflater

fun ViewGroup.inflateView(@LayoutRes layoutId: Int, attachToRoot: Boolean = false): View =
    layoutInflater.inflate(layoutId, this, attachToRoot)
