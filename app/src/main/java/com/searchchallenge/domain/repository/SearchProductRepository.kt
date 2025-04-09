package com.searchchallenge.domain.repository

import com.searchchallenge.ui.composable.model.Product

interface SearchProductRepository {
    suspend fun searchProducts(query: String): List<Product>
}
