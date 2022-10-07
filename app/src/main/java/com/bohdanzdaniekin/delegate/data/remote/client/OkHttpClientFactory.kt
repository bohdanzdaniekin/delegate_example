package com.bohdanzdaniekin.delegate.data.remote.client

import com.bohdanzdaniekin.delegate.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

object OkHttpClientFactory {

    private const val CONNECT_TIMEOUT = 2L
    private const val READ_WRITE_TIMEOUT = 2L

    fun createClient(): OkHttpClient {
        return OkHttpClient.Builder().apply {
            connectTimeout(CONNECT_TIMEOUT, TimeUnit.MINUTES)
            readTimeout(READ_WRITE_TIMEOUT, TimeUnit.MINUTES)
            writeTimeout(READ_WRITE_TIMEOUT, TimeUnit.MINUTES)

            if (BuildConfig.DEBUG) {
                addInterceptor(loggingInterceptor())
            }
        }.build()
    }

    private fun loggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
}