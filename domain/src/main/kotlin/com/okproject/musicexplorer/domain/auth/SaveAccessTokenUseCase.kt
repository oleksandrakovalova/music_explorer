package com.okproject.musicexplorer.domain.auth

interface SaveAccessTokenUseCase {
    suspend operator fun invoke(token: String)
}