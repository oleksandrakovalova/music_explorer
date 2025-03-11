package com.okproject.musicexplorer.domain.auth

interface ClearAccessTokenUseCase {
    suspend operator fun invoke()
}