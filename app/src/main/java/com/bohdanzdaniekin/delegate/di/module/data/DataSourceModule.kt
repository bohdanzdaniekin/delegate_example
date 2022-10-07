package com.bohdanzdaniekin.delegate.di.module.data

import com.bohdanzdaniekin.delegate.data.remote.datasource.CharacterRemoteDataSource
import com.bohdanzdaniekin.delegate.domain.datasource.CharacterDataSource
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface DataSourceModule {

    @Singleton
    @Binds
    fun bindCharacterDataSource(dataSource: CharacterRemoteDataSource): CharacterDataSource
}