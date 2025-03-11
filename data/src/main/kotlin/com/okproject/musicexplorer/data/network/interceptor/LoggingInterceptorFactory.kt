package com.okproject.musicexplorer.data.network.interceptor

import com.okproject.musicexplorer.data.network.Header
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import timber.log.Timber

object LoggingInterceptorFactory {
    private const val LOGGING_TAG = "Network_Requests"

    fun create(level: Level) =
        HttpLoggingInterceptor { message ->
            Timber.tag(LOGGING_TAG).d(message)
        }.setLevel(level)
            .apply {
                redactHeader(Header.AUTHORIZATION)
                redactHeader(Header.COOKIE)
            }
}