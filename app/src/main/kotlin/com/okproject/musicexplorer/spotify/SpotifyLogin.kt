package com.okproject.musicexplorer.spotify

import android.app.Activity
import com.spotify.sdk.android.auth.AuthorizationClient

object SpotifyLogin {
    private val authorizationRequest = SpotifyAuthRequestFactory.create(
        SpotifyAuthScope.ListeningHistory.USER_TOP_READ,
        SpotifyAuthScope.Playback.APP_REMOTE_CONTROL,
        SpotifyAuthScope.Playlists.PLAYLIST_READ_PRIVATE,
        SpotifyAuthScope.Playlists.PLAYLIST_READ_COLLABORATIVE
    )

    internal fun Activity.loginInBrowser() {
        AuthorizationClient.openLoginInBrowser(
            this,
            authorizationRequest
        )
    }
}
