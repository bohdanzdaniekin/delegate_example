package com.bohdanzdaniekin.delegate.ui.toolbar

import androidx.annotation.LayoutRes
import com.bohdanzdaniekin.delegate.ui.view.AppBarLayoutStub

interface ToolbarInterface {

    @get:LayoutRes
    val layoutId: Int

    fun invalidate()

    fun setTitle(title: String)

    fun bindViews(appBarLayoutStub: AppBarLayoutStub)
}