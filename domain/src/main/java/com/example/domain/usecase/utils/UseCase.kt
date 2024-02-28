package com.example.domain.usecase.utils

import android.util.Log
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

// TODO. Dispatcher 를 명확하게 따로 받는 이유가 있을까?
abstract class UseCase<in P, R>(private val coroutineDispatcher: CoroutineDispatcher = Dispatchers.IO){
    suspend operator fun invoke(params: P): Result<R>{
        return try {
            withContext(coroutineDispatcher){
                execute(params).let {
                    Log.d("UseCase Success",": ${params}")
                    Result.Success(it)
                }
            }
            // TODO 무조건 HttpException 인가? 다른 Exception이 발생할 가능성이 없나?
        } catch (e: HttpException){
            Result.Error(e)
        }
    }

    @Throws(RuntimeException::class)
    protected abstract suspend fun execute(param: P): R
}