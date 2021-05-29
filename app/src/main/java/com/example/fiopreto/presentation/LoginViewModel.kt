package com.example.fiopreto.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fiopreto.data.LoginRepository
import com.example.fiopreto.data.remote.ResultWrapper
import com.example.fiopreto.data.remote.login.LoginResponse
import com.example.fiopreto.extensions.viewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel(
    private val repository : LoginRepository
): ViewModel(){

    private val _headersLiveData by viewState<LoginResponse>()
    val headersLiveData: LiveData<ViewState<LoginResponse>> = _headersLiveData

    fun login(email: String, password: String) {
        //_headersLiveData.value = ViewState.loading(true)
        viewModelScope.launch(Dispatchers.Main) {
            handleLogin(repository.login(email, password))

        }

    }

    private fun handleLogin(response: ResultWrapper<LoginResponse>) {
        when(response){
            is ResultWrapper.Success -> _headersLiveData.value = ViewState.success(response.data)
            is ResultWrapper.Failure -> _headersLiveData.value = ViewState.error(response.error)
        }
        //_headersLiveData.value = ViewState.loading(false)
    }

    fun clearStatus() {
        //_headersLiveData.value = ViewState.success(null)
    }
}