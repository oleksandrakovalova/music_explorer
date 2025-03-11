package com.okproject.musicexplorer.data.auth

import com.okproject.musicexplorer.domain.auth.AuthorizationRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first

class AuthorizationRepositoryImpl(
    private val dataSource: AuthorizationDataSource
): AuthorizationRepository {
    override val accessTokenFlow: Flow<String?> = dataSource.accessTokenFlow

    override suspend fun getAccessToken(): String? =
        accessTokenFlow.first()

    override suspend fun saveAccessToken(token: String) {
        dataSource.saveAccessToken(token)
    }
    override suspend fun clearAccessToken() {
        dataSource.clearAccessToken()
    }
}