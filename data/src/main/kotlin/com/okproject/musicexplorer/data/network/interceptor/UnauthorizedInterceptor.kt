package com.okproject.musicexplorer.data.network.interceptor

import com.okproject.musicexplorer.data.network.UNAUTHORIZED_CODE
import com.okproject.musicexplorer.domain.auth.ClearAccessTokenUseCase
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response

class UnauthorizedInterceptor(
    private val clearAccessTokenUseCase: ClearAccessTokenUseCase
): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val response = chain.proceed(originalRequest)
        if (response.code == UNAUTHORIZED_CODE) {
            runBlocking {
                clearAccessTokenUseCase()
            }
        }
        return response
    }
}