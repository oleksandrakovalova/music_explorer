package com.okproject.musicexplorer

import android.app.Application
import com.okproject.musicexplorer.di.authorizationModule
import com.okproject.musicexplorer.di.coroutineModule
import com.okproject.musicexplorer.di.networkingModule
import com.okproject.musicexplorer.di.searchModule
import com.okproject.musicexplorer.di.storageModule
import com.okproject.musicexplorer.di.uiModule
import com.okproject.musicexplorer.di.userChartModule
import com.okproject.musicexplorer.logging.LoggingTree
import com.okproject.musicexplorer.logging.TimberLogger
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class MusicExplorerApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(LoggingTree())
        startKoin {
            logger(TimberLogger())
            androidContext(this@MusicExplorerApplication)
            modules(
                authorizationModule,
                userChartModule,
                searchModule,
                uiModule,
                coroutineModule,
                networkingModule,
                storageModule
            )
        }
    }
}