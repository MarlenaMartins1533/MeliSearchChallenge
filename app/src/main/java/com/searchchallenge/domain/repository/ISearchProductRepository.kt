package com.searchchallenge.domain.repository

import com.searchchallenge.domain.model.ProductDomain

interface ISearchProductRepository {
    suspend fun searchProducts(query: String): List<ProductDomain>
}
