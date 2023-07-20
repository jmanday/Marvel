package com.jmanday.domain.model

sealed class Resource<T>(
    val data: T? = null,
    val exception: Exception? = null
) {
    class Success<T>(data: T): Resource<T>(data)
    class Error<T>(exception: Exception): Resource<T>(exception = exception)
}
