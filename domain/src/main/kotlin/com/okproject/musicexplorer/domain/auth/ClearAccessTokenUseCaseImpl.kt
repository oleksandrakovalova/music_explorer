package com.okproject.musicexplorer.domain.auth

class ClearAccessTokenUseCaseImpl(
    private val authRepository: AuthorizationRepository
): ClearAccessTokenUseCase {
    override suspend fun invoke() {
        authRepository.clearAccessToken()
    }
}