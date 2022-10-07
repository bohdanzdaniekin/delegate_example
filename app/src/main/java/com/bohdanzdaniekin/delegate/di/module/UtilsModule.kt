package com.bohdanzdaniekin.delegate.di.module

import com.bohdanzdaniekin.delegate.data.util.DispatcherProviderImpl
import com.bohdanzdaniekin.delegate.domain.util.DispatcherProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
interface UtilsModule {

    companion object {

        @Singleton
        @Provides
        fun provideDispatcherProvider(): DispatcherProvider = DispatcherProviderImpl()
    }
}