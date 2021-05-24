package com.example.fiopreto.presentation

class ViewState<Type>(
    val data: Type? = null,
    val state: State,
    //val isLoading: Boolean = false,
    val error: Throwable? = null
) {

    companion object {
        /*fun <T> loading(isLoading: Boolean) =
            ViewState<T>(isLoading = isLoading, state = State.LOADING)*/

        fun <T> error(error: Throwable?) =
            ViewState<T>(state = State.ERROR, error = error)

        fun <T> success(data: T?) =
            ViewState<T>(data = data, state = State.SUCCESS)
    }

    enum class State {
        LOADING, SUCCESS, ERROR
    }
}