package com.okproject.musicexplorer.domain.auth

import kotlinx.coroutines.flow.Flow

interface AuthorizationRepository {

    val accessTokenFlow: Flow<String?>

    suspend fun getAccessToken(): String?
    suspend fun saveAccessToken(token: String)
    suspend fun clearAccessToken()
}