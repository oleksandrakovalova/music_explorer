package com.okproject.musicexplorer.domain.auth

class GetAccessTokenUseCaseImpl(
    private val authRepository: AuthorizationRepository
): GetAccessTokenUseCase {
    override suspend fun invoke(): String? =
        authRepository.getAccessToken()
}