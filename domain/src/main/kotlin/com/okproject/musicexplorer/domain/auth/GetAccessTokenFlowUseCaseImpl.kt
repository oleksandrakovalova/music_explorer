package com.okproject.musicexplorer.domain.auth

import kotlinx.coroutines.flow.Flow

class GetAccessTokenFlowUseCaseImpl(
    private val authRepository: AuthorizationRepository
): GetAccessTokenFlowUseCase {
    override fun invoke(): Flow<String?> =
        authRepository.accessTokenFlow
}