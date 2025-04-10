package com.searchchallenge.data.repository

import com.searchchallenge.data.remote.datasource.ISearchProductDataSource
import com.searchchallenge.data.remote.datasource.parameterprovider.productResponseListParameterProvider
import com.searchchallenge.domain.model.ProductDomain
import com.searchchallenge.domain.repository.ISearchProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SearchProductRepository(
    private val searchProductDataSource: ISearchProductDataSource
) : ISearchProductRepository {
    override suspend fun searchProducts(query: String): List<ProductDomain> =
        withContext(Dispatchers.IO) {
            searchProductDataSource.searchProducts(query) ?: productResponseListParameterProvider
        }
}
