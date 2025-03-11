package com.okproject.musicexplorer.domain.auth

import kotlinx.coroutines.flow.Flow

interface GetAccessTokenFlowUseCase {
    operator fun invoke(): Flow<String?>
}