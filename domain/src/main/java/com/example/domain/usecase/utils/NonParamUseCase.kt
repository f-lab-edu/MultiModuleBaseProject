package com.example.domain.usecase.utils

import kotlinx.coroutines.CoroutineDispatcher
import retrofit2.HttpException
import kotlinx.coroutines.withContext
import java.lang.RuntimeException

abstract class NonParamUseCase<R>(private val coroutineDispatcher: CoroutineDispatcher){
    suspend operator fun invoke(): Result<R> {
        return try {
            withContext(coroutineDispatcher){
                execute().let {
                    Result.Success(it)
                }
            }
        } catch (e: HttpException){
            Result.Error(e)
        }
    }

    @Throws(RuntimeException::class)
    protected abstract suspend fun execute(): R
}