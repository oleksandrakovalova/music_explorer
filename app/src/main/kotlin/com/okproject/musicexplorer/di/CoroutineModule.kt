package com.okproject.musicexplorer.di

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.koin.core.qualifier.named
import org.koin.dsl.module
import timber.log.Timber

val coroutineModule = module {
    single<CoroutineDispatcher>(named(DEFAULT_DISPATCHER)) {
        Dispatchers.Default
    }
    single<CoroutineDispatcher>(named(MAIN_DISPATCHER)) {
        Dispatchers.Main
    }
    single<CoroutineDispatcher>(named(IO_DISPATCHER)) {
        Dispatchers.IO
    }
    single<CoroutineScope>(named(APPLICATION_SCOPE)) {
        CoroutineScope(
            SupervisorJob() +
                    get<CoroutineDispatcher>(named(DEFAULT_DISPATCHER)) +
                    CoroutineExceptionHandler { _, throwable ->
                        Timber.tag(APPLICATION_SCOPE).e(throwable)
                    }
        )
    }
}

internal const val DEFAULT_DISPATCHER = "default_dispatcher"
internal const val MAIN_DISPATCHER = "main_dispatcher"
internal const val IO_DISPATCHER = "io_dispatcher"

internal const val APPLICATION_SCOPE = "application_scope"