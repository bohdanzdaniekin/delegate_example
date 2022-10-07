package com.bohdanzdaniekin.delegate.ui.toolbar

import android.app.Activity
import androidx.appcompat.widget.Toolbar
import com.bohdanzdaniekin.delegate.R
import com.bohdanzdaniekin.delegate.ui.view.AppBarLayoutStub

abstract class BaseToolbarInterface(private val activity: Activity) : ToolbarInterface {

    protected var toolbar: Toolbar? = null

    override fun invalidate() {
        var appBarLayoutStubLayout = activity.findViewById<AppBarLayoutStub>(R.id.toolbarViewStub)
        if (appBarLayoutStubLayout.layoutResource != layoutId) {
            appBarLayoutStubLayout.layoutResource = layoutId
            appBarLayoutStubLayout = appBarLayoutStubLayout.inflate()
            bindViews(appBarLayoutStubLayout)
        }
    }
}