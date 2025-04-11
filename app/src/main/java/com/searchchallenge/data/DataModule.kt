package com.searchchallenge.data

import com.searchchallenge.data.remote.datasource.ISearchProductDataSource
import com.searchchallenge.data.remote.datasource.SearchProductDataSource
import com.searchchallenge.data.remote.mapper.ResponseToDomainMapper
import com.searchchallenge.data.remote.service.MeLiApiService
import com.searchchallenge.data.repository.SearchProductRepository
import com.searchchallenge.domain.repository.ISearchProductRepository
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {
    factory {
        Retrofit.Builder()
            .baseUrl("https://api.mercadolibre.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    factory { get<Retrofit>().create(MeLiApiService::class.java) }

    factory { ResponseToDomainMapper() }

    factory<ISearchProductDataSource> {
        SearchProductDataSource(
            api = get(),
            mapper = get()
        )
    }

    factory<ISearchProductRepository> { SearchProductRepository(get()) }
}
