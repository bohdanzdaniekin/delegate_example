package com.bohdanzdaniekin.delegate.ui.util

import com.bohdanzdaniekin.delegate.domain.entity.Action

interface OnActionListener<T : Action> {

    fun onAction(action: T)
}