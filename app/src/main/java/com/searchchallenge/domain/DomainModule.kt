package com.searchchallenge.domain

import com.searchchallenge.domain.usecase.SearchProductUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { SearchProductUseCase(get()) }
}
