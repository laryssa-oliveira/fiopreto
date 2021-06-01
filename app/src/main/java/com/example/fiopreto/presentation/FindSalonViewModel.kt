package com.example.fiopreto.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fiopreto.Cities
import com.example.fiopreto.data.FindSalonRepository
import com.example.fiopreto.data.remote.ResultWrapper
import com.example.fiopreto.extensions.viewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FindSalonViewModel (
    private val repository: FindSalonRepository
) : ViewModel() {

    private val _findSalonListLiveData by viewState<List<Cities>>()
    val findSalonListLiveData: LiveData<ViewState<List<Cities>>> = _findSalonListLiveData

    fun getCities() {
        //_postFeedListLiveData.value = ViewState.loading(true)
        viewModelScope.launch(Dispatchers.Main) {
            handleResponse(repository.getCities())
        }
    }


    private fun handleResponse(response: ResultWrapper<List<Cities>>) {
        when (response) {
            is ResultWrapper.Success -> _findSalonListLiveData.value =
                ViewState.success(response.data)
            is ResultWrapper.Failure -> _findSalonListLiveData.value =
                ViewState.error(response.error)
        }
        // _postFeedListLiveData.value = ViewState.loading(false)
    }
}