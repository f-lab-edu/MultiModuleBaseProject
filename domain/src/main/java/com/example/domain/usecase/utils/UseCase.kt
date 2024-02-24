package com.example.domain.usecase.utils

import android.util.Log
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

abstract class UseCase<in P, R>(private val coroutineDispatcher: CoroutineDispatcher = Dispatchers.IO){
    suspend operator fun invoke(params: P): Result<R>{
        return try {
            withContext(coroutineDispatcher){
                execute(params).let {
                    Log.d("UseCase Success",": ${params}")
                    Result.Success(it)
                }
            }
        } catch (e: HttpException){
            Result.Error(e)
        }
    }

    @Throws(RuntimeException::class)
    protected abstract suspend fun execute(param: P): R
}