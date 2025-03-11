package com.okproject.musicexplorer.data.network.client

import okhttp3.Interceptor
import okhttp3.OkHttpClient

object OkHttpClientFactory {

    fun create(vararg interceptors: Interceptor): OkHttpClient {
        val builder = OkHttpClient.Builder()
        for (interceptor in interceptors) {
            builder.addInterceptor(interceptor)
        }
        return builder.build()
    }
}