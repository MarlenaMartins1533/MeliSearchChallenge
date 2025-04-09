package com.searchchallenge.domain.usecase

import com.searchchallenge.ui.composable.model.Product
import com.searchchallenge.ui.composable.parameterprovider.productListParameterProvider

class SearchProductUseCase (
) {
    suspend operator fun invoke(query: String): List<Product> {
        return productListParameterProvider
    }
}
