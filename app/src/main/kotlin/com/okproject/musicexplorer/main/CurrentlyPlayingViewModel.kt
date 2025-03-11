package com.okproject.musicexplorer.main

import android.graphics.Bitmap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.okproject.musicexplorer.spotify.toPlayerTrackData
import com.spotify.android.appremote.api.AppRemote
import com.spotify.protocol.types.ImageUri
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CurrentlyPlayingViewModel: ViewModel() {
    private var appRemote: AppRemote? = null

    private val _currentTrackFlow: MutableStateFlow<PlayingTrackData?> = MutableStateFlow(null)
    val currentTrackFlow: StateFlow<PlayingTrackData?> = _currentTrackFlow.asStateFlow()

    private val _coverImageFlow: MutableStateFlow<Bitmap?> = MutableStateFlow(null)
    val coverImageFlow: StateFlow<Bitmap?> = _coverImageFlow.asStateFlow()

    init {
        initCoverImageFlow()
    }

    private fun initCoverImageFlow() {
        viewModelScope.launch {
            currentTrackFlow.collect { currentTrack ->
                currentTrack?.imageUri?.let { getRemoteImage(it) }
            }
        }
    }

    fun onAppRemoteConnected(appRemote: AppRemote) {
        this.appRemote = appRemote
        subscribeToPlayerState()
    }

    private fun AppRemote?.ifConnected(block: AppRemote.() -> Unit) {
        this?.let { appRemote ->
            if (appRemote.isConnected) {
                block.invoke(appRemote)
            }
        }
    }

    private fun subscribeToPlayerState() {
        appRemote.ifConnected {
            this.observePlayerState()
        }
    }

    private fun AppRemote.observePlayerState() = this.playerApi.subscribeToPlayerState()
        .setEventCallback { playerState ->
            viewModelScope.launch {
                playerState?.let {
                    _currentTrackFlow.emit(it.track?.toPlayerTrackData())
                }
            }
        }

    private fun getRemoteImage(uri: ImageUri) {
        appRemote.ifConnected {
            this.getImage(uri)
        }
    }

    private fun AppRemote.getImage(uri: ImageUri) = this.imagesApi.getImage(uri)
        .setResultCallback {
            viewModelScope.launch {
                _coverImageFlow.emit(it)
            }
        }

    fun onAppRemoteDisconnected() {
        appRemote = null
    }

    private companion object {
        private val TAG = CurrentlyPlayingViewModel::class.java.simpleName
    }
}