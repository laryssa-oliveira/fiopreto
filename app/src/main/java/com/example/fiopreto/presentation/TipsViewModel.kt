package com.example.fiopreto.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fiopreto.PostTips

import com.example.fiopreto.data.TipsRepository
import com.example.fiopreto.data.remote.ResultWrapper
import com.example.fiopreto.extensions.viewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TipsViewModel(
    private val repository: TipsRepository
) : ViewModel() {

    private val _postTipsListLiveData by viewState<List<PostTips>>()
    val postTipsListLiveData: LiveData<ViewState<List<PostTips>>> = _postTipsListLiveData

    fun getPostsTips() {
        //_postTipsListLiveData.value = ViewState.loading(true)
        viewModelScope.launch(Dispatchers.Main) {
            handleResponse(repository.getPostsTips())
        }
    }


    private fun handleResponse(response: ResultWrapper<List<PostTips>>) {
        when (response) {
            is ResultWrapper.Success -> _postTipsListLiveData.value =
                ViewState.success(response.data)
            is ResultWrapper.Failure -> _postTipsListLiveData.value =
                ViewState.error(response.error)
        }
        // _postTipsListLiveData.value = ViewState.loading(false)
    }
}

