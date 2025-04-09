package com.searchchallenge.domain.usecase

import com.searchchallenge.domain.repository.ISearchProductRepository
import com.searchchallenge.ui.composable.model.Product

class SearchProductUseCase (
    private val searchProductRepository: ISearchProductRepository
) {
    suspend operator fun invoke(query: String): List<Product> {
        return searchProductRepository.searchProducts(query)
    }
}
