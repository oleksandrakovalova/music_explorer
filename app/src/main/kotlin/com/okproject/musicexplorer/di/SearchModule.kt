package com.okproject.musicexplorer.di

import com.okproject.musicexplorer.domain.search.SearchPlaylistsUseCaseImpl
import com.okproject.musicexplorer.domain.search.SearchPlaylistsUseCase
import com.okproject.musicexplorer.domain.search.SearchRepository
import com.okproject.musicexplorer.data.search.SearchRepositoryImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.core.qualifier.named
import org.koin.dsl.module

val searchModule = module {
    single<SearchRepository> {
        SearchRepositoryImpl(
            searchApi = get(),
            dispatcher =get(named(IO_DISPATCHER))
        )
    }
    singleOf(::SearchPlaylistsUseCaseImpl) {
        bind<SearchPlaylistsUseCase>()
    }
}