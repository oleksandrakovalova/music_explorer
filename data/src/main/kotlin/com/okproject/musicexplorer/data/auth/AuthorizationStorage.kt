package com.okproject.musicexplorer.data.auth

import kotlinx.coroutines.flow.Flow

interface AuthorizationStorage {
    val accessTokenFlow: Flow<String?>
    suspend fun saveAccessToken(token: String)
    suspend fun clearAccessToken()
}