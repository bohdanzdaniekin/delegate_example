package com.bohdanzdaniekin.delegate.domain.entity

data class Resource<out T>(
    val status: Status,
    val data: T?,
    val error: Throwable? = null,
    val message: String? = null
) {

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    inline fun <R> mapNotNull(action: (T) -> R?): Resource<R> {
        return Resource(status, data?.let { data -> action(data) }, error, message)
    }

    companion object {

        fun <T> success(data: T?): Resource<T> = Resource(Status.SUCCESS, data)

        fun <T> error(message: String, error: Throwable?): Resource<T> =
            Resource(Status.ERROR, null, error, message)

        fun <T> loading(data: T? = null): Resource<T> = Resource(Status.LOADING, data)
    }
}