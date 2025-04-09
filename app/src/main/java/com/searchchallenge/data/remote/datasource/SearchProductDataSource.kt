package com.searchchallenge.data.remote.datasource

import com.searchchallenge.data.model.product.ProductResponse
import com.searchchallenge.data.model.searchproduct.SearchProductResponse
import com.searchchallenge.data.remote.service.MeLiApiService

class SearchProductDataSource(private val api: MeLiApiService) : ISearchProductDataSource {
    override suspend fun searchProducts(query: String): SearchProductResponse =
        api.searchProducts(query)

    override suspend fun getProduct(productId: String): ProductResponse =
        api.getProduct(productId)
}

