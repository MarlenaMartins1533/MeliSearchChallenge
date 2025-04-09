package com.searchchallenge.data.remote.datasource

import com.searchchallenge.data.model.product.ProductResponse
import com.searchchallenge.data.model.searchproduct.SearchProductResponse

interface ISearchProductDataSource {

    suspend fun searchProducts(query: String): SearchProductResponse
    suspend fun getProduct(productId: String): ProductResponse
}