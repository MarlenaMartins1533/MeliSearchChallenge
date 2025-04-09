package com.searchchallenge.data


import com.searchchallenge.data.repository.SearchProductRepository
import com.searchchallenge.domain.repository.ISearchProductRepository
import org.koin.dsl.module

val dataModule = module {
    factory<ISearchProductRepository> { SearchProductRepository(get()) }
}
