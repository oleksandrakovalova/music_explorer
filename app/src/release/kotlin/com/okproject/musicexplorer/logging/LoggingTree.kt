package com.okproject.musicexplorer.logging

import android.util.Log
import timber.log.Timber

class LoggingTree: Timber.Tree() {
    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        if (priority == Log.ERROR || priority == Log.WARN) {
            // TODO SEND ERROR REPORTS TO CRASHLYTICS
        }
    }
}