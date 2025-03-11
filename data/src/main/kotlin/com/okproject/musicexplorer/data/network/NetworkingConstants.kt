package com.okproject.musicexplorer.data.network

internal const val SPOTIFY_API_BASE_URL = "https://api.spotify.com/v1/"

internal const val UNAUTHORIZED_CODE = 401

internal const val CONTENT_TYPE: String = "application/json"

internal object Header {
    const val AUTHORIZATION = "Authorization"
    const val ACCEPT = "accept"
    const val COOKIE = "Cookie"
}