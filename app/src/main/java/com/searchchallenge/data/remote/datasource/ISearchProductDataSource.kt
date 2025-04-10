package com.searchchallenge.data.remote.datasource

import com.searchchallenge.domain.model.ProductDomain

interface ISearchProductDataSource {
    suspend fun searchProducts(query: String): List<ProductDomain>?
}
