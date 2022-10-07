package com.bohdanzdaniekin.delegate.di.module.view_module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bohdanzdaniekin.delegate.di.module.view_module.ViewModelFactory
import com.bohdanzdaniekin.delegate.di.module.view_module.ViewModelKey
import com.bohdanzdaniekin.delegate.ui.CharactersViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
interface ViewModelModule {

    @Binds
    @Singleton
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(CharactersViewModel::class)
    fun bindCharactersViewModel(viewModel: CharactersViewModel): ViewModel
}