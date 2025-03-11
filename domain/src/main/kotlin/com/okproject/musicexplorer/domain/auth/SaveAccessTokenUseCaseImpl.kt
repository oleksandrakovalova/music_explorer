package com.okproject.musicexplorer.domain.auth

class SaveAccessTokenUseCaseImpl(
    private val authRepository: AuthorizationRepository
): SaveAccessTokenUseCase {
    override suspend fun invoke(token: String) {
        authRepository.saveAccessToken(token)
    }
}