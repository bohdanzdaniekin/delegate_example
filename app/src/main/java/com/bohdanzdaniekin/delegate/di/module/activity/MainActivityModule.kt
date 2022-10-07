package com.bohdanzdaniekin.delegate.di.module.activity

import android.app.Activity
import com.bohdanzdaniekin.delegate.di.qualifier.scope.ActivityScope
import com.bohdanzdaniekin.delegate.ui.MainActivity
import dagger.Binds
import dagger.Module

@Module
interface MainActivityModule {

    @Binds
    @ActivityScope
    fun bindActivity(activity: MainActivity): Activity
}
