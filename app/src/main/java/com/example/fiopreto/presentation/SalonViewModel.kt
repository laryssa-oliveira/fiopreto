package com.example.fiopreto.presentation

import android.app.DownloadManager
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fiopreto.PostSalon
import com.example.fiopreto.data.SalonRepository
import com.example.fiopreto.data.remote.ResultWrapper
import com.example.fiopreto.extensions.viewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.experimental.builder.createInstance
import retrofit2.http.Path
import retrofit2.http.Query

class SalonViewModel(
    private val repository: SalonRepository
) : ViewModel() {

    private val _postSalonListLiveData by viewState<List<PostSalon>>()
    val postSalonListLiveData: LiveData<ViewState<List<PostSalon>>> = _postSalonListLiveData

    fun getPostSalon(ibge: Int) {
        //_postSalonListLiveData.value = ViewState.loading(true)

        viewModelScope.launch(Dispatchers.Main) {

            handleResponse(repository.getPostsSalon(ibge))
        }
    }


    private fun handleResponse(response: ResultWrapper<List<PostSalon>>) {
        when (response) {
            is ResultWrapper.Success -> _postSalonListLiveData.value =
                ViewState.success(response.data)
            is ResultWrapper.Failure -> _postSalonListLiveData.value =
                ViewState.error(response.error)
        }
        // _postSalonListLiveData.value = ViewState.loading(false)
    }
}