package com.bohdanzdaniekin.delegate.di.module

import com.bohdanzdaniekin.delegate.di.module.activity.MainActivityFragmentProvider
import com.bohdanzdaniekin.delegate.di.module.activity.MainActivityModule
import com.bohdanzdaniekin.delegate.di.qualifier.scope.ActivityScope
import com.bohdanzdaniekin.delegate.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivitiesProvider {

    @ActivityScope
    @ContributesAndroidInjector(
        modules = [
            MainActivityFragmentProvider::class,
            MainActivityModule::class
        ]
    )
    abstract fun contributeMainActivityInjector(): MainActivity
}