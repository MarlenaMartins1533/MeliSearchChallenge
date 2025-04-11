package com.searchchallenge.domain.usecase

import com.searchchallenge.domain.model.ProductDomain
import com.searchchallenge.domain.repository.ISearchProductRepository

class SearchProductUseCase(
    private val searchProductRepository: ISearchProductRepository
) {
    suspend operator fun invoke(query: String): List<ProductDomain> {
        return searchProductRepository.searchProducts(query)
    }
}
