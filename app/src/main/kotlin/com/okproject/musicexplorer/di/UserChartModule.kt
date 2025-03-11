package com.okproject.musicexplorer.di

import com.okproject.musicexplorer.data.userschart.UsersChartRepositoryImpl
import com.okproject.musicexplorer.domain.userschart.GetUsersTopArtistsUseCase
import com.okproject.musicexplorer.domain.userschart.GetUsersTopArtistsUseCaseImpl
import com.okproject.musicexplorer.domain.userschart.GetUsersTopTracksUseCase
import com.okproject.musicexplorer.domain.userschart.GetUsersTopTracksUseCaseImpl
import com.okproject.musicexplorer.domain.userschart.UsersChartRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.core.qualifier.named
import org.koin.dsl.module

val userChartModule = module {
    single<UsersChartRepository> {
        UsersChartRepositoryImpl(
            usersChartApi = get(),
            dispatcher = get(named(IO_DISPATCHER))
        )
    }
    singleOf(::GetUsersTopTracksUseCaseImpl) {
        bind<GetUsersTopTracksUseCase>()
    }
    singleOf(::GetUsersTopArtistsUseCaseImpl) {
        bind<GetUsersTopArtistsUseCase>()
    }
}