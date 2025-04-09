package com.searchchallenge.data.repository

import com.searchchallenge.data.remote.service.MeLiApiService
import com.searchchallenge.domain.repository.ISearchProductRepository
import com.searchchallenge.ui.composable.model.Product

class SearchProductRepository(
    private val apiService: MeLiApiService
) : ISearchProductRepository {
    override suspend fun searchProducts(query: String): List<Product> {
        return emptyList()
    }
}
