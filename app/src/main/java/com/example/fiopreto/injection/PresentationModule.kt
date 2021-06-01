package com.example.fiopreto.injection

import com.example.fiopreto.presentation.*
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    viewModel { FeedViewModel(get()) }
    viewModel { SalonViewModel(get()) }
    viewModel { LoginViewModel(get()) }
    viewModel { UploadImageViewModel(get(),get()) }
    viewModel { FindSalonViewModel(get()) }
    viewModel { TipsViewModel(get()) }
    viewModel { UploadImgTipsViewModel(get(),get()) }
}