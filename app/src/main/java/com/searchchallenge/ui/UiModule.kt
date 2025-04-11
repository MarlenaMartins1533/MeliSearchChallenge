package com.searchchallenge.ui

import com.searchchallenge.ui.composable.mapper.DomainToProductMapper
import com.searchchallenge.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {

    factory { DomainToProductMapper() }

    viewModel {
        MainViewModel(
            searchProductUseCase = get(),
            domainToProductMapper = get()
        )
    }
}
