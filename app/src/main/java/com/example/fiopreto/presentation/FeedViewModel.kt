package com.example.fiopreto.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fiopreto.data.FeedRepository
import com.example.fiopreto.PostFeed
import com.example.fiopreto.data.remote.ResultWrapper
import com.example.fiopreto.extensions.viewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FeedViewModel(
    private val repository: FeedRepository
) : ViewModel() {

    private val _postFeedListLiveData by viewState<List<PostFeed>>()
    val postFeedListLiveData: LiveData<ViewState<List<PostFeed>>> = _postFeedListLiveData

    fun getPostsFeed() {
        //_postFeedListLiveData.value = ViewState.loading(true)
        viewModelScope.launch(Dispatchers.Main) {
            handleResponse(repository.getPostsFeed())
        }
    }


    private fun handleResponse(response: ResultWrapper<List<PostFeed>>) {
        when (response) {
            is ResultWrapper.Success -> _postFeedListLiveData.value =
                ViewState.success(response.data)
            is ResultWrapper.Failure -> _postFeedListLiveData.value =
                ViewState.error(response.error)
        }
        // _postFeedListLiveData.value = ViewState.loading(false)
    }
}