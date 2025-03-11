package com.okproject.musicexplorer.domain.auth

interface GetAccessTokenUseCase {
    suspend operator fun invoke(): String?
}