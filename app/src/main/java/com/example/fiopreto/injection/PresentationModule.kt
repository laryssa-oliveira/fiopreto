package com.example.fiopreto.injection

import com.example.fiopreto.presentation.FeedViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    viewModel { FeedViewModel(get()) }
}