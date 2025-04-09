package com.searchchallenge.data

import com.searchchallenge.data.remote.datasource.ISearchProductDataSource
import com.searchchallenge.data.remote.datasource.SearchProductDataSource
import com.searchchallenge.data.remote.service.MeLiApiService
import com.searchchallenge.data.repository.SearchProductRepository
import com.searchchallenge.domain.repository.ISearchProductRepository
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

val dataModule = module {

    factory { GsonConverterFactory.create() }
    factory {
        Retrofit.Builder()
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    })
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .build()
            )
            .addConverterFactory(
                MoshiConverterFactory.create(
                    Moshi.Builder()
                        .add(KotlinJsonAdapterFactory())
                        .build()
                )
            )
            .baseUrl("https://api.mercadolibre.com/sites/MLA/")
            .addConverterFactory(get<GsonConverterFactory>())
            .build()
    }
    factory {get<Retrofit>().create(MeLiApiService::class.java) }
    factory<ISearchProductDataSource> {
        SearchProductDataSource(
            api = get()
        )
    }
    factory<ISearchProductRepository> { SearchProductRepository(get()) }
}
