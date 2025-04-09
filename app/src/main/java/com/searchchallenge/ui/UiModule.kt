package com.searchchallenge.ui

import com.searchchallenge.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {
    viewModel {
        MainViewModel(searchProductUseCase = get())
    }
}
