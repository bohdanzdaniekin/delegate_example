package com.bohdanzdaniekin.delegate.di.module.activity

import com.bohdanzdaniekin.delegate.di.module.fragment.FirstFragmentModule
import com.bohdanzdaniekin.delegate.di.qualifier.scope.FragmentScope
import com.bohdanzdaniekin.delegate.ui.FirstFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface MainActivityFragmentProvider {

    @FragmentScope
    @ContributesAndroidInjector(modules = [FirstFragmentModule::class])
    fun contributeFirstFragment(): FirstFragment
}
