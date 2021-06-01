package com.example.fiopreto.presentation

import android.app.Application
import android.net.Uri
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.fiopreto.ImageTips
import com.example.fiopreto.data.repository.UploadTipsRepository
import com.example.fiopreto.data.remote.ResultWrapper
import com.example.fiopreto.extensions.viewState
import com.example.fiopreto.utils.FileUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody

class UploadImgTipsViewModel(
    application: Application,
    private val repository: UploadTipsRepository
) : AndroidViewModel(application) {

    private val _uploadImgTipsListLiveData by viewState<ImageTips>()
    val uploadImgTipsListLiveData: LiveData<ViewState<ImageTips>> = _uploadImgTipsListLiveData
    var imageUri: Uri? = null

    fun uploadImageTips() {

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
                        handleResponse(repository.uploadImageTips(body))
                    }
                }
            }
        }
    }

    private fun handleResponse(response: ResultWrapper<ImageTips>) {
        when (response) {
            is ResultWrapper.Success -> _uploadImgTipsListLiveData.value =
                ViewState.success(response.data)
            is ResultWrapper.Failure -> _uploadImgTipsListLiveData.value =
                ViewState.error(response.error)
        }
        // _postFeedListLiveData.value = ViewState.loading(false)
    }


}

