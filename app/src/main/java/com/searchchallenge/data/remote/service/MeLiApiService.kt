package com.searchchallenge.data.remote.service

import com.searchchallenge.data.model.product.ProductResponse
import com.searchchallenge.data.model.searchproduct.SearchProductResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MeLiApiService {
    @GET("sites/MLA/search")
    fun searchProducts(@Query("q") query: String): SearchProductResponse

    @GET("items/{itemId}")
    fun getProduct(@Path("itemId") itemId: String): ProductResponse
}
