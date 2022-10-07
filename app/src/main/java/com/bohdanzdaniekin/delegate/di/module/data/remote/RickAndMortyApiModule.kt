package com.bohdanzdaniekin.delegate.di.module.data.remote

import com.bohdanzdaniekin.delegate.data.remote.api.RickAndMortyApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
class RickAndMortyApiModule : ApiProviderModule<RickAndMortyApi> {

    @Provides
    @Singleton
    override fun provideApi(retrofit: Retrofit): RickAndMortyApi = retrofit.create()
}