package com.okproject.musicexplorer.spotify

object SpotifyAuthScope {
    object Images {
        const val UGC_IMAGE_UPLOAD = "ugc-image-upload"
    }
    object SpotifyConnect {
        const val USER_READ_PLAYBACK_STATE = "user-read-playback-state"
        const val USER_MODIFY_PLAYBACK_STATE = "user-modify-playback-state"
        const val USER_READ_CURRENTLY_PLAYING = "user-read-currently-playing"
    }
    object Playback {
        const val APP_REMOTE_CONTROL = "app-remote-control"
        const val STREAMING = "streaming"
    }
    object Playlists {
        const val PLAYLIST_READ_PRIVATE = "playlist-read-private"
        const val PLAYLIST_READ_COLLABORATIVE = "playlist-read-collaborative"
        const val PLAYLIST_MODIFY_PRIVATE = "playlist-modify-private"
        const val PLAYLIST_MODIFY_PUBLIC = "playlist-modify-public"
    }
    object Follow {
        const val USER_FOLLOW_MODIFY = "user-follow-modify"
        const val USER_FOLLOW_READ = "user-follow-read"
    }
    object ListeningHistory {
        const val USER_READ_PLAYBACK_POSITION = "user-read-playback-position"
        const val USER_TOP_READ = "user-top-read"
        const val USER_READ_RECENTLY_PLAYED = "user-read-recently-played"
    }
    object Library {
        const val USER_LIBRARY_MODIFY = "user-library-modify"
        const val USER_LIBRARY_READ = "user-library-read"
    }
    object Users {
        const val USER_READ_EMAIL = "user-read-email"
        const val USER_READ_PRIVATE = "user-read-private"
    }
}