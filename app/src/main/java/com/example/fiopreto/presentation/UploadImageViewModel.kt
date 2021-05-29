package com.example.fiopreto.presentation

import android.app.Application
import android.net.Uri
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fiopreto.ImageFeed
import com.example.fiopreto.data.UploadFeedRepository
import com.example.fiopreto.data.remote.ResultWrapper
import com.example.fiopreto.extensions.viewState
import com.example.fiopreto.utils.FileUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File


class UploadImageViewModel(
    application: Application,
    private val repository: UploadFeedRepository
) : AndroidViewModel(application) {

    private val _uploadImageListLiveData by viewState<ImageFeed>()
    val uploadImageListLiveData: LiveData<ViewState<ImageFeed>> = _uploadImageListLiveData
    var imageUri: Uri? = null

    fun uploadImageFeed() {

        imageUri?.let { uri ->
            val file = FileUtils.getFile(getApplication<Application>().applicationContext, imageUri)
            file?.let {
                // create RequestBody instance from file
                getApplication<Application>().contentResolver.getType(uri)?.let {
                    // create RequestBody instance from file
                    val requestFile: RequestBody = file.asRequestBody(
                        it.toMediaTypeOrNull()
                    )

                    // MultipartBody.Part is used to send also the actual file name

                    // MultipartBody.Part is used to send also the actual file name
                    val body = MultipartBody.Part.createFormData("file", file.name, requestFile)
                    //_postFeedListLiveData.value = ViewState.loading(true)
                    viewModelScope.launch(Dispatchers.Main) {
                        handleResponse(repository.uploadImageFeed(body))
                    }
                }
            }
        }
    }

    private fun handleResponse(response: ResultWrapper<ImageFeed>) {
        when (response) {
            is ResultWrapper.Success -> _uploadImageListLiveData.value =
                ViewState.success(response.data)
            is ResultWrapper.Failure -> _uploadImageListLiveData.value =
                ViewState.error(response.error)
        }
        // _postFeedListLiveData.value = ViewState.loading(false)
    }


}