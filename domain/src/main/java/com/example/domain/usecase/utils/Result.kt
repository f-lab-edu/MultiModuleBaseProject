package com.example.domain.usecase.utils

// TODO abstract class 로 변경하면? abstract class vs sealed class
sealed class Result <out R> {

    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: Throwable) : Result<Nothing>()
    data object Loading : Result<Nothing>()
}

val Result<*>.Success
    get() = this is Result.Success && data != null

val <T> Result<T>.response: T?
    get() = (this as? Result.Success)?.data

val <T> Result<T>.Error: Throwable?
    get() = (this as? Result.Error)?.exception

fun <T> Result<T>.successOr(fallback: T): T {
    return (this as? Result.Success<T>)?.data ?: fallback
}