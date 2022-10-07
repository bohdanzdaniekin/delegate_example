package com.bohdanzdaniekin.delegate.ui.toolbar

import android.app.Activity
import com.bohdanzdaniekin.delegate.R
import com.bohdanzdaniekin.delegate.di.qualifier.scope.ActivityScope
import com.bohdanzdaniekin.delegate.ui.view.AppBarLayoutStub
import com.google.android.material.tabs.TabLayout
import javax.inject.Inject

@ActivityScope
class TabToolbarInterface @Inject constructor(activity: Activity) : BaseToolbarInterface(activity) {

    override val layoutId = R.layout.toolbar_tabs

    var tabLayout: TabLayout? = null
        private set

    override fun setTitle(title: String) {
        toolbar?.title = title
    }

    override fun bindViews(appBarLayoutStub: AppBarLayoutStub) {
        /*tabLayout = appBarLayoutStub.tabLayout
        toolbar = appBarLayoutStub.toolbar*/
    }
}