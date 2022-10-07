package com.bohdanzdaniekin.delegate.di.module.data.remote

import retrofit2.Retrofit

interface ApiProviderModule<T> {

    fun provideApi(retrofit: Retrofit): T
}