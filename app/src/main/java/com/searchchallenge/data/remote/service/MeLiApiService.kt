package com.searchchallenge.data.remote.service

import com.searchchallenge.data.model.searchproduct.SearchProductResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MeLiApiService {
    @GET("products/search")
    fun searchProducts(
        @Query("status") status: String = "active",
        @Query("site_id") siteId: String = "MLB",
        @Query("q") query: String
    ): Call<SearchProductResponse>
}
