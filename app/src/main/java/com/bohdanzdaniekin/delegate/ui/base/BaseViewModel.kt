package com.bohdanzdaniekin.delegate.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bohdanzdaniekin.delegate.domain.entity.Resource
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    protected val _errors = MutableSharedFlow<Throwable>()
    val errors = _errors.asSharedFlow()

    private val exceptionHandler = CoroutineExceptionHandler { context, throwable ->
        postError(throwable)
    }

    private val coroutineContext = viewModelScope.coroutineContext + exceptionHandler
    protected val scope = CoroutineScope(coroutineContext)

    protected fun postError(exception: Throwable) {
        viewModelScope.launch { _errors.emit(exception) }
    }

    protected fun handleError(exception: Throwable): Throwable = exception

    protected fun <T> runRequest(
        stateFlow: MutableStateFlow<T>,
        request: suspend () -> Flow<T>
    ) {
        scope.launch {
            request().collect { result -> stateFlow.value = result }
        }
    }
}