package com.okproject.musicexplorer.data.auth

import kotlinx.coroutines.flow.Flow

class AuthorizationDataSourceImpl(
private val authStorage: AuthorizationStorage
): AuthorizationDataSource {
    override val accessTokenFlow: Flow<String?> = authStorage.accessTokenFlow

    override suspend fun saveAccessToken(token: String) {
        authStorage.saveAccessToken(token)
    }

    override suspend fun clearAccessToken() {
        authStorage.clearAccessToken()
    }
}