package com.okproject.musicexplorer.spotify

import com.spotify.sdk.android.auth.AuthorizationRequest
import com.spotify.sdk.android.auth.AuthorizationResponse.Type.TOKEN

object SpotifyAuthRequestFactory {
    fun create(vararg scopes: String): AuthorizationRequest =
        AuthorizationRequest.Builder(CLIENT_ID, TOKEN, AUTH_REDIRECT_URI)
            .setScopes(scopes)
            .build()
}