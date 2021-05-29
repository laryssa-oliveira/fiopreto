package com.example.fiopreto.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fiopreto.PostSalon
import com.example.fiopreto.data.SalonRepository
import com.example.fiopreto.data.remote.ResultWrapper
import com.example.fiopreto.extensions.viewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SalonViewModel (
    private val repository : SalonRepository
) : ViewModel() {

    private val _postSalonListLiveData by viewState<List<PostSalon>>()
    val postSalonListLiveData: LiveData<ViewState<List<PostSalon>>> = _postSalonListLiveData

    fun getPostSalon() {
        //_postSalonListLiveData.value = ViewState.loading(true)
        viewModelScope.launch (Dispatchers.Main) {
            handleResponse(repository.getPostsSalon())
        }
    }


    private fun handleResponse(response: ResultWrapper<List<PostSalon>>) {
        when(response){
            is ResultWrapper.Success -> _postSalonListLiveData.value =
                ViewState.success(response.data)
            is ResultWrapper.Failure -> _postSalonListLiveData.value = ViewState.error(response.error)
        }
        // _postSalonListLiveData.value = ViewState.loading(false)
    }
}