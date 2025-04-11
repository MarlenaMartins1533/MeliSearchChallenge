package com.searchchallenge.data.remote.datasource

import android.util.Log
import com.searchchallenge.data.model.searchproduct.SearchProductResponse
import com.searchchallenge.data.remote.mapper.ResponseToDomainMapper
import com.searchchallenge.data.remote.service.MeLiApiService
import com.searchchallenge.domain.model.ProductDomain
import retrofit2.Call

class SearchProductDataSource(
    private val api: MeLiApiService,
    private val mapper: ResponseToDomainMapper
) : ISearchProductDataSource {

    override suspend fun searchProducts(query: String): List<ProductDomain>? {
        val searchProducts: SearchProductResponse?

        try {
            val call: Call<SearchProductResponse> =
                api.searchProducts(status = "active", siteId = "MLB", query = query)
            val response = call.execute()

            if (response.isSuccessful) {
                searchProducts = response.body()
                return searchProducts?.results?.map { mapper(it) }
            } else {
                Log.e("Error ", " ")
                return null
            }

        } catch (e: Exception) {
            // TO DO Lidar com erros de rede ou outras exceções e criar os estados de error
            Log.e("Error: ", " Exception ", e)
            return null
        }
    }
}
