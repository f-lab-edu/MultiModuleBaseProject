package com.example.presentation.utils

import com.example.domain.usecase.utils.Error
import com.example.domain.usecase.utils.Result
import com.example.domain.usecase.utils.Success
import com.example.domain.usecase.utils.response

fun <T> Result<T>.executeResult(
    onSuccess: (T) -> Unit,
    onError: ((Throwable?)-> Unit)? = null
) {
    when{
        this.Success -> response?.let{ onSuccess(it) }
        //if use failure case
        //
        else -> onError?.let { onError(Error) }
    }
}