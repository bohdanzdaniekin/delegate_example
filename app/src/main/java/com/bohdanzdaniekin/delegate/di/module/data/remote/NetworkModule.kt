package com.bohdanzdaniekin.delegate.di.module.data.remote

import dagger.Module

@Module(
    includes = [
        RetrofitModule::class,
        RickAndMortyApiModule::class
    ]
)
interface NetworkModule