package com.bohdanzdaniekin.delegate.di

import android.app.Application
import com.bohdanzdaniekin.delegate.App
import com.bohdanzdaniekin.delegate.di.module.data.DataSourceModule
import com.bohdanzdaniekin.delegate.di.module.data.RepositoryModule
import com.bohdanzdaniekin.delegate.di.module.data.remote.NetworkModule
import com.bohdanzdaniekin.delegate.di.module.ActivitiesProvider
import com.bohdanzdaniekin.delegate.di.module.UtilsModule
import com.bohdanzdaniekin.delegate.di.module.view_module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ViewModelModule::class,
        ActivitiesProvider::class,
        NetworkModule::class,
        RepositoryModule::class,
        DataSourceModule::class,
        UtilsModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    override fun inject(instance: App)
}