package com.bohdanzdaniekin.delegate.ui.base

import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity<VB : ViewBinding>(
    @LayoutRes layoutId: Int
) : DaggerAppCompatActivity(layoutId) {

    protected abstract val binding: VB
}