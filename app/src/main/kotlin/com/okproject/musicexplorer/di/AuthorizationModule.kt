package com.okproject.musicexplorer.di

import com.okproject.musicexplorer.data.auth.AuthorizationDataSource
import com.okproject.musicexplorer.data.auth.AuthorizationDataSourceImpl
import com.okproject.musicexplorer.data.auth.AuthorizationRepositoryImpl
import com.okproject.musicexplorer.domain.auth.AuthorizationRepository
import com.okproject.musicexplorer.domain.auth.ClearAccessTokenUseCase
import com.okproject.musicexplorer.domain.auth.ClearAccessTokenUseCaseImpl
import com.okproject.musicexplorer.domain.auth.GetAccessTokenFlowUseCase
import com.okproject.musicexplorer.domain.auth.GetAccessTokenFlowUseCaseImpl
import com.okproject.musicexplorer.domain.auth.GetAccessTokenUseCase
import com.okproject.musicexplorer.domain.auth.GetAccessTokenUseCaseImpl
import com.okproject.musicexplorer.domain.auth.SaveAccessTokenUseCase
import com.okproject.musicexplorer.domain.auth.SaveAccessTokenUseCaseImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val authorizationModule = module {
    singleOf(::AuthorizationDataSourceImpl) {
        bind<AuthorizationDataSource>()
    }
    singleOf(::AuthorizationRepositoryImpl) {
        bind<AuthorizationRepository>()
    }
    singleOf(::GetAccessTokenFlowUseCaseImpl) {
        bind<GetAccessTokenFlowUseCase>()
    }
    singleOf(::GetAccessTokenUseCaseImpl) {
        bind<GetAccessTokenUseCase>()
    }
    singleOf(::SaveAccessTokenUseCaseImpl) {
        bind<SaveAccessTokenUseCase>()
    }
    singleOf(::ClearAccessTokenUseCaseImpl) {
        bind<ClearAccessTokenUseCase>()
    }
}