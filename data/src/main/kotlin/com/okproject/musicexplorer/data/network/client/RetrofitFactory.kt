package com.okproject.musicexplorer.data.network.client

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.okproject.musicexplorer.data.network.CONTENT_TYPE
import com.okproject.musicexplorer.data.network.SPOTIFY_API_BASE_URL
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit

object RetrofitFactory {
    private val json = Json {
        ignoreUnknownKeys = true
        isLenient = true
        classDiscriminator = "type"
    }
    fun create(client: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .client(client)
            .baseUrl(SPOTIFY_API_BASE_URL)
            .addConverterFactory( json.asConverterFactory(CONTENT_TYPE.toMediaType()))
            .build()
}