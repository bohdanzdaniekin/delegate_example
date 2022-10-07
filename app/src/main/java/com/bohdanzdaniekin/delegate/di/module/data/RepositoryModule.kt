package com.bohdanzdaniekin.delegate.di.module.data

import com.bohdanzdaniekin.delegate.data.remote.repository.CharacterRemoteRepository
import com.bohdanzdaniekin.delegate.domain.repository.CharacterRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface RepositoryModule {

    @Singleton
    @Binds
    fun bindCharacterRepository(repository: CharacterRemoteRepository): CharacterRepository
}