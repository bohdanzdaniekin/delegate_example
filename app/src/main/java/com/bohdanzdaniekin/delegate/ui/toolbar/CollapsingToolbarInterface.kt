package com.bohdanzdaniekin.delegate.ui.toolbar

import android.app.Activity
import android.widget.ImageView
import com.bohdanzdaniekin.delegate.R
import com.bohdanzdaniekin.delegate.di.qualifier.scope.ActivityScope
import com.bohdanzdaniekin.delegate.ui.view.AppBarLayoutStub
import com.google.android.material.appbar.CollapsingToolbarLayout
import javax.inject.Inject

@ActivityScope
class CollapsingToolbarInterface @Inject constructor(
    activity: Activity
) : BaseToolbarInterface(activity) {

    override val layoutId = R.layout.toolbar_collapsing

    var toolbarImageView: ImageView? = null
        private set

    var collapsingToolbarLayout: CollapsingToolbarLayout? = null
        private set

    override fun setTitle(title: String) {
        collapsingToolbarLayout?.title = title
    }

    override fun bindViews(appBarLayoutStub: AppBarLayoutStub) {
        /*toolbarImageView = appBarLayoutStub.toolbarImageView
        collapsingToolbarLayout = appBarLayoutStub.collapsingToolbar*/
    }
}