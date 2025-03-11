package com.okproject.musicexplorer.di

import android.content.SharedPreferences
import com.okproject.musicexplorer.data.auth.AuthorizationStorage
import com.okproject.musicexplorer.data.storage.AuthorizationStorageImpl
import com.okproject.musicexplorer.data.storage.EncryptedPreferencesFactory
import org.koin.core.qualifier.named
import org.koin.dsl.module

val storageModule = module {
    single<SharedPreferences>(named(AUTHORIZATION_QUALIFIER)) {
        EncryptedPreferencesFactory(context = get()).create(AUTHORIZATION_PREFS_NAME)
    }
    single<AuthorizationStorage> {
        AuthorizationStorageImpl(
            authPreferences = get(named(AUTHORIZATION_QUALIFIER)),
            externalScope = get(named(APPLICATION_SCOPE)),
            dispatcher = get(named(IO_DISPATCHER))
        )
    }
}
internal const val AUTHORIZATION_QUALIFIER: String = "authorization"
private const val AUTHORIZATION_PREFS_NAME = "authorization_preferences"