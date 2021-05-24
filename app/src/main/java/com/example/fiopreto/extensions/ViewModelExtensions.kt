package com.example.fiopreto.extensions

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fiopreto.presentation.ViewState

fun <T> ViewModel.viewState() = lazy{
    MutableLiveData<ViewState<T>>()
}