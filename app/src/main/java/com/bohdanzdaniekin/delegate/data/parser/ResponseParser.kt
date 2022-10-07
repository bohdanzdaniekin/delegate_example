package com.bohdanzdaniekin.delegate.data.parser

import com.bohdanzdaniekin.delegate.domain.entity.Resource
import retrofit2.Response
import javax.inject.Inject

class ResponseParser @Inject constructor(
    private val errorParser: ErrorParser
) {

    suspend fun <T> getResponse(
        defaultErrorMessage: String = "Unexpected error",
        request: suspend () -> Response<T>
    ): Resource<T> {
        return try {
            val result = request.invoke()
            if (result.isSuccessful) {
                return Resource.success(result.body())
            } else {
                val errorResponse = errorParser.parseError(result)
                Resource.error(errorResponse?.message ?: defaultErrorMessage, errorResponse)
            }
        } catch (e: Throwable) {
            Resource.error(defaultErrorMessage, null)
        }
    }
}