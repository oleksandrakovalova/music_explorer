package com.okproject.musicexplorer.data.network.interceptor

import com.okproject.musicexplorer.data.network.CONTENT_TYPE
import com.okproject.musicexplorer.data.network.Header
import com.okproject.musicexplorer.domain.auth.GetAccessTokenUseCase
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor(
    private val getAccessTokenUseCase: GetAccessTokenUseCase
): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val token = runBlocking {
            getAccessTokenUseCase().orEmpty()
        }
        val request = chain.request().newBuilder()
            .addHeader(Header.AUTHORIZATION, token.toBearer())
            .addHeader(Header.ACCEPT, CONTENT_TYPE)
            .build()
        return chain.proceed(request)
    }
    private fun String.toBearer(): String = "Bearer $this"
}