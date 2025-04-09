package com.searchchallenge.domain.usecase

import com.searchchallenge.domain.repository.SearchProductRepository
import com.searchchallenge.ui.composable.model.Product

class SearchProductUseCase (
    private val searchProductRepository: SearchProductRepository
) {
    suspend operator fun invoke(query: String): List<Product> {
        return searchProductRepository.searchProducts(query)
    }
}
