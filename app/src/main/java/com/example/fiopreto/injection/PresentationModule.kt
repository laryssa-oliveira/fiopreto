package com.example.fiopreto.injection

import com.example.fiopreto.presentation.FeedViewModel
import com.example.fiopreto.presentation.LoginViewModel
import com.example.fiopreto.presentation.SalonViewModel
import com.example.fiopreto.presentation.UploadImageViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    viewModel { FeedViewModel(get()) }
    viewModel { SalonViewModel(get()) }
    viewModel { LoginViewModel(get()) }
    viewModel { UploadImageViewModel(get(),get()) }
}