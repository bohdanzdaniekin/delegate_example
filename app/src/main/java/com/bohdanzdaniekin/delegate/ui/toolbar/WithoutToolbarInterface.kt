package com.bohdanzdaniekin.delegate.ui.toolbar

import android.app.Activity
import com.bohdanzdaniekin.delegate.R
import com.bohdanzdaniekin.delegate.di.qualifier.scope.ActivityScope
import com.bohdanzdaniekin.delegate.ui.view.AppBarLayoutStub
import javax.inject.Inject

@ActivityScope
class WithoutToolbarInterface @Inject constructor(
    activity: Activity
) : BaseToolbarInterface(activity) {

    override val layoutId = R.layout.toolbar_without_toolbar

    override fun setTitle(title: String) {
        //none
    }

    override fun bindViews(appBarLayoutStub: AppBarLayoutStub) {
        // none
    }
}