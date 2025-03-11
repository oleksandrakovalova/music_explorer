package com.okproject.musicexplorer.data.network

import retrofit2.Response

fun <T, R> Response<T>.toResult(mapper: (T) -> R): Result<R> {
    val body = this.body()
    val errorBody = this.errorBody()?.string()
    return when {
        this.isSuccessful && body != null -> Result.success(mapper(body))
        else -> Result.failure(
            ApiResponseException(
                code = this.code(),
                errorBody = errorBody.toString()
            )
        )
    }
}

// TODO move to separate package and class
class ApiResponseException(
    val code: Int,
    errorBody: String
) : Exception() {
    override val message =
        "API request failed with status code $code:\n$errorBody"
}
