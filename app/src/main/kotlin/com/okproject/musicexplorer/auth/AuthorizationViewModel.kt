package com.okproject.musicexplorer.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.okproject.musicexplorer.domain.auth.GetAccessTokenFlowUseCase
import com.okproject.musicexplorer.domain.auth.SaveAccessTokenUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class AuthorizationViewModel(
    getAccessTokenFlowUseCase: GetAccessTokenFlowUseCase,
    private val saveAccessTokenUseCase: SaveAccessTokenUseCase
): ViewModel() {
    val authorizationStateFlow: StateFlow<AuthorizationState> = getAccessTokenFlowUseCase()
        .map {
            if (it.isNullOrBlank().not()) {
                AuthorizationState.AUTHORIZED
            } else {
                AuthorizationState.UNAUTHORIZED
            }
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = AuthorizationState.UNKNOWN
        )

    fun isAuthorized(): Boolean = authorizationStateFlow.value == AuthorizationState.AUTHORIZED

    fun onUserTokenUpdated(token: String) {
        viewModelScope.launch {
            saveAccessTokenUseCase(token)
        }
    }
}