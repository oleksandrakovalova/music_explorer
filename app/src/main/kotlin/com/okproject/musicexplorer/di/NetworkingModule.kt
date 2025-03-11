package com.okproject.musicexplorer.di

import com.okproject.musicexplorer.BuildConfig
import com.okproject.musicexplorer.data.network.api.PlaylistApi
import com.okproject.musicexplorer.data.network.api.SearchApi
import com.okproject.musicexplorer.data.network.api.UsersChartApi
import com.okproject.musicexplorer.data.network.client.OkHttpClientFactory
import com.okproject.musicexplorer.data.network.client.RetrofitFactory
import com.okproject.musicexplorer.data.network.interceptor.HeaderInterceptor
import com.okproject.musicexplorer.data.network.interceptor.LoggingInterceptorFactory
import com.okproject.musicexplorer.data.network.interceptor.UnauthorizedInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import retrofit2.Retrofit

val networkingModule = module {
    singleOf(::HeaderInterceptor)
    singleOf(::UnauthorizedInterceptor)
    single<HttpLoggingInterceptor> {
        val level = if (BuildConfig.DEBUG) Level.BODY else Level.BASIC
        LoggingInterceptorFactory.create(level)
    }
    single<OkHttpClient> {
        OkHttpClientFactory.create(
            interceptors = arrayOf(
                get<HeaderInterceptor>(),
                get<UnauthorizedInterceptor>(),
                get<HttpLoggingInterceptor>()
            )
        )
    }
    single<Retrofit> {
        RetrofitFactory.create(get<OkHttpClient>())
    }
    single<UsersChartApi> {
        get<Retrofit>().create(UsersChartApi::class.java)
    }
    single<SearchApi> {
        get<Retrofit>().create(SearchApi::class.java)
    }
    single<PlaylistApi> {
        get<Retrofit>().create(PlaylistApi::class.java)
    }
}

