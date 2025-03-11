package com.okproject.musicexplorer.data.storage

import android.content.SharedPreferences
import android.content.SharedPreferences.OnSharedPreferenceChangeListener
import androidx.core.content.edit
import com.okproject.musicexplorer.data.auth.AuthorizationStorage
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AuthorizationStorageImpl(
    private val authPreferences: SharedPreferences,
    externalScope: CoroutineScope,
    private val dispatcher: CoroutineDispatcher
): AuthorizationStorage {
    override val accessTokenFlow: Flow<String?> = callbackFlow {
        val onUserTokenChanged = OnSharedPreferenceChangeListener { _, key ->
            if (key == ACCESS_TOKEN_KEY) {
                launch {
                    val token = getAccessToken()
                    send(token)
                }
            }
        }
        authPreferences.registerOnSharedPreferenceChangeListener(onUserTokenChanged)
        send(getAccessToken())

        awaitClose {
            authPreferences.unregisterOnSharedPreferenceChangeListener(onUserTokenChanged)
        }
    }.shareIn(
        scope = externalScope,
        started = SharingStarted.WhileSubscribed(),
        replay = 1
    )

    private suspend fun getAccessToken(): String? =
        withContext(dispatcher) {
            authPreferences.getString(ACCESS_TOKEN_KEY, null)
        }

    override suspend fun saveAccessToken(token: String) =
        withContext(dispatcher) {
            authPreferences.edit {
                putString(ACCESS_TOKEN_KEY, token)
            }
        }

    override suspend fun clearAccessToken() {
        withContext(dispatcher) {
            authPreferences.edit {
                remove(ACCESS_TOKEN_KEY)
            }
        }
    }

    companion object {
        private const val ACCESS_TOKEN_KEY = "access_token"
    }
}