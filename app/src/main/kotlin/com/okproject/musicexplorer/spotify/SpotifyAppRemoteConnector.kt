package com.okproject.musicexplorer.spotify

import android.content.Context
import com.spotify.android.appremote.api.ConnectionParams
import com.spotify.android.appremote.api.Connector.ConnectionListener
import com.spotify.android.appremote.api.SpotifyAppRemote
import timber.log.Timber

object SpotifyAppRemoteConnector {
    private val TAG = SpotifyAppRemoteConnector::class.java.simpleName
    private var appRemote: SpotifyAppRemote? = null

    private val connectionParams = ConnectionParams.Builder(CLIENT_ID)
        .setRedirectUri(APP_REMOTE_REDIRECT_URI)
        .setAuthMethod(ConnectionParams.AuthMethod.APP_ID)
        .showAuthView(false)
        .build()

    fun connect(context: Context, onConnected: (SpotifyAppRemote) -> Unit) {
        SpotifyAppRemote.connect(context, connectionParams, object : ConnectionListener {
            override fun onConnected(spotifyAppRemote: SpotifyAppRemote) {
                appRemote = spotifyAppRemote
                onConnected.invoke(spotifyAppRemote)
                Timber.tag(TAG).d("Spotify App Remote Connected!")
            }

            override fun onFailure(exception: Throwable) {
                Timber.tag(TAG).e(exception, "Connection to Spotify App Remote is failed: ${exception.message}")
            }
        })
    }

    fun disconnect(onDisconnected: () -> Unit) {
        appRemote?.let {
            SpotifyAppRemote.disconnect(it)
        }
        onDisconnected.invoke()
        appRemote = null
    }
}